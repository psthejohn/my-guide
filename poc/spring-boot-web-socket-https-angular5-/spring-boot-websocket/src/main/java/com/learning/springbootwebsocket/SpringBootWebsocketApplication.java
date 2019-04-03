package com.learning.springbootwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebsocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebsocketApplication.class, args);
	}

//	@Bean
//	public ServletWebServerFactory servletContainer() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//		tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//		return tomcat;
//	}
	
//	private Connector createStandardConnector() {
//		
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		connector.setPort(8085);
//		connector.setSecure(false);
//		connector.setRedirectPort(8086);
//		return connector;
//	}
}
