package com.vaaniga.invest.signup.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    /*protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            	.anyRequest()
            	.authenticated()
            	.and()
            .httpBasic()
            	.and()
	        .sessionManagement()
	        	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        	.and()
	        .csrf()
	        	.disable()
        	.cors();
    }
    @Bean
	  CorsConfigurationSource corsConfigurationSource() {
	      CorsConfiguration configuration = new CorsConfiguration();
	      configuration.setAllowedOrigins(Arrays.asList("https://vaaniga-invest-app.herokuapp.com/"));
	      configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	      source.registerCorsConfiguration("/**", configuration);
	      return source;
	  }
    */
	
	protected void configure(HttpSecurity http) throws Exception {
        http
        	.cors()
        	.and()
        	.csrf().disable();
    }
	
}
