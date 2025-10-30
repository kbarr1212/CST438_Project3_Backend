package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                // allow access to these routes without login
                .requestMatchers("/", "/public/**", "/api/test", "/health", "/items", "/chats", "/messages" ).permitAll()
                // everything else requires authentication
                .anyRequest().authenticated()
            )
            // remove the default login form (for APIs)
            .httpBasic().disable()
            .formLogin().disable();
        return http.build();
    }
}