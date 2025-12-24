package com.app.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityWebAppConfigs extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Autowired
    public SecurityWebAppConfigs(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
                .antMatchers("/register/**").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/system").hasAnyRole("SYSTEM")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied");
	}

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/resources/**");
    }
}