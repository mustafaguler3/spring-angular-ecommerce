package com.example.demo.security;

import com.example.demo.utils.CustomAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomAccessDeniedHandler accessDeniedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                        .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                .authorizeRequests()
                .requestMatchers("/api/products/**").permitAll()
                .requestMatchers("/api/**").permitAll()
                .anyRequest().permitAll();

        return http.build();
    }
}















