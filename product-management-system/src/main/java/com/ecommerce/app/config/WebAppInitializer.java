package com.ecommerce.app.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) {

        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);

        sc.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext webContext =
                new AnnotationConfigWebApplicationContext();
        webContext.register(WebMVCConfig.class);

        ServletRegistration.Dynamic dispatcher =
                sc.addServlet("dispatcher",
                        new DispatcherServlet(webContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}