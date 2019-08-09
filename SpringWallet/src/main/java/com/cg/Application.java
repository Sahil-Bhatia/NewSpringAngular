package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application { // Start up class
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		/*
		 * This single line does following : 1. Create
		 * AnnotationConfigApplicationContext 2. It uses @ComponentScan for All Child
		 * packages Does request mapping to "/" 
		 * 3. It reads application.properties 3.1 Found one property "server.port=3000"
		 * 4. Launches Embedded Tomcat Server 
		 * 5. Wait for you to terminate the process
		 */
		
		
		
		/*
		 * Run application and test using postman. In postman use "Requset Header" =Accept with value = application/xml
		 * or application/json
		 */
	}
}
