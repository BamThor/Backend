package com.sojuthon.sojuthonbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SojuthonBackendApplication {
	public static final String APPLICATION_LOCATIONS = "spring.config.location="
			+ "classpath:application.yml,"
			+ "classpath:aws.yml";


	public static void main(String[] args) {
		new SpringApplicationBuilder(SojuthonBackendApplication.class)
				.properties(APPLICATION_LOCATIONS)
				.run(args);
//		SpringApplication.run(SojuthonBackendApplication.class, args);
	}

}
