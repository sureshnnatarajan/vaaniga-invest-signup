package com.vaaniga.invest.signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaanigaInvestSignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaanigaInvestSignupApplication.class, args);
	}
	
	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/signUp")
						.allowedOrigins("https://vaaniga-invest-app.herokuapp.com/");
			}
		};
	}*/

}
