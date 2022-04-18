package com.revature.todobackend.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    /* instead of having the cross origin on every single controller, This is how you can add a global configuration */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
                .allowedOrigins(System.getenv("EC2_IP"))
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE");
			}
		};
	}
}
