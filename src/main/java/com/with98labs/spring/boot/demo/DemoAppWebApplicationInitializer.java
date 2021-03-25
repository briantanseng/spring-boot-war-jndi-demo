package com.with98labs.spring.boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.WebApplicationInitializer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class DemoAppWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        try {
            Context initCxt =  new InitialContext();
            String profile =  (String) initCxt.lookup("cell/nodes/DefaultNode01/persistent/Profile");

            System.out.println("profile = "+profile);

            servletContext.setInitParameter("spring.profiles.active", profile);
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

}