/*
 * 
 */
package com.stackroute.foodieapi.rs.service.impl;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * The Class WebConfiguration.
 */
@Configuration
public class WebConfiguration {
    
    public WebConfiguration() {
		super();
	}

	/**
     * H 2 servlet registration.
     *
     * @return the servlet registration bean
     */
    @Bean
    ServletRegistrationBean h2servletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }
}
