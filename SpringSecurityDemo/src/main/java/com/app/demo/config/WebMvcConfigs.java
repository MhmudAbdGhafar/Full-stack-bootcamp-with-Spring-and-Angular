package com.app.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "com.app.demo")
@PropertySource("classpath:jdbc.properties")
public class WebMvcConfigs implements WebMvcConfigurer {

    private final Environment environment;

    @Autowired
    public WebMvcConfigs(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource securityDatasource()
    {
        //create connection pool
        ComboPooledDataSource securityDatasource = new ComboPooledDataSource();

        //set the jdbc driver
        try {

            // set database connection properties
            securityDatasource.setDriverClass(environment.getProperty("jdbc.driver"));
            securityDatasource.setUser(environment.getProperty("jdbc.username"));
            securityDatasource.setPassword(environment.getProperty("jdbc.password"));
            securityDatasource.setJdbcUrl(environment.getProperty("jdbc.url"));

            //set connection pool
            securityDatasource.setInitialPoolSize(Integer.parseInt(Objects.requireNonNull(
                    environment.getProperty("connection.pool.initialPoolSize"))));
            securityDatasource.setMinPoolSize(Integer.parseInt(Objects.requireNonNull(
                    environment.getProperty("connection.pool.minPoolSize"))));
            securityDatasource.setMaxPoolSize(Integer.parseInt(Objects.requireNonNull(
                    environment.getProperty("connection.pool.maxPoolSize"))));
            securityDatasource.setMaxIdleTime(Integer.parseInt(Objects.requireNonNull(
                    environment.getProperty("connection.pool.maxIdleTime"))));

        }catch (PropertyVetoException ex)
        {
            throw new RuntimeException(ex);
        }
        return securityDatasource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(securityDatasource());
        sessionFactory.setPackagesToScan("com.app.demo.model");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {

        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    private Properties hibernateProperties() {

        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

        return properties;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}