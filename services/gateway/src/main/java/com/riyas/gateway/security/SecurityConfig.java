package com.riyas.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    return http
        .csrf(csrf -> csrf.disable())
        .authorizeExchange(exchange -> exchange
            .pathMatchers("/eureka/**").permitAll() // allow Eureka client access
            .anyExchange().authenticated() // secure everything else
        )
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults())) // enable OAuth2 Resource Server (JWT)
        .build();
  }
}
