package com.stackroute.maverick.springbootzuulgatwayproxy;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.springbootzuulgatwayproxy.filters.ErrorFilter;
import com.example.springbootzuulgatwayproxy.filters.PostFilter;
import com.example.springbootzuulgatwayproxy.filters.PreFilter;
import com.example.springbootzuulgatwayproxy.filters.RouteFilter;

@SpringBootApplication
@EnableDiscoveryClient  // for eureka server to find this application
@EnableZuulProxy // to act as api-gateway
public class SpringBootZuulgatwayproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootZuulgatwayproxyApplication.class, args);
	}

	@Bean
	public ServletWebServerFactory servletContainer() {
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
		return tomcat;
	}
	
	private Connector createStandardConnector() {
		// Connector connector = new
		// Connector("org.apache.coyote.http11.Http11NioProtocol");
		// connector.setPort(0);
		// return connector;
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		connector.setScheme("http");
		connector.setPort(8092);
		connector.setSecure(false);
		connector.setRedirectPort(8093);
		return connector;
	}
	
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
