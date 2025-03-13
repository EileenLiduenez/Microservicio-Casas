package com.pragma.microserviciocasas.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // 🔹 Desactiva protección CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // 🔹 Permite acceso a todos los endpoints sin autenticación
                )
                .formLogin(form -> form.disable())  // 🔹 Desactiva el formulario de login
                .httpBasic(basic -> basic.disable());  // 🔹 Desactiva la autenticación básica

        return http.build();
    }
}