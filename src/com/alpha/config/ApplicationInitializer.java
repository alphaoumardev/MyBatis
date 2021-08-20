package org.example.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(ApplicationConfig.class);

        ServletRegistration.Dynamic serveletRegistration =servletContext.addServlet("mvc",new DispatcherServlet((WebApplicationContext) context));
        serveletRegistration.setLoadOnStartup(1);
        serveletRegistration.addMapping("/");
    }

}
