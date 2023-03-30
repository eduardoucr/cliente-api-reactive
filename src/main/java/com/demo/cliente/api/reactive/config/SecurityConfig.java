package com.demo.cliente.api.reactive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .requestMatchers(HttpMethod.DELETE)
                .hasRole("admin")
                .requestMatchers("/v1/api/cliente/**")
                .hasAnyRole("user","admin")
                .requestMatchers("/v1/api/login/**")
                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                //  .httpBasic();
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(new CustomJwtAuthenticationConverter() );

        http.oauth2Login();
        return http.build();

    }

}
