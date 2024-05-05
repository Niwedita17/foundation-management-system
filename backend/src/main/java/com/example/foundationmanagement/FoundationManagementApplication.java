package com.example.foundationmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FoundationManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoundationManagementApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:3000") // Replace with your frontend URL
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Allow specific HTTP methods
						.allowedHeaders("*"); // Allow all headers
			}
		};
	}
}
