package com.estoque.controle_estoque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
                
                .requestMatchers("/login", "/error").permitAll()
                
                
                .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                
                
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                
                .loginPage("/login")
                
                
                .defaultSuccessUrl("/produtos/listar", true)
                
                
                .permitAll()
            )
            .logout(logout -> logout
                
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}