package com.estoque.controle_estoque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.estoque.controle_estoque.util.JwtFiltro;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //Feijão da segurança
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFiltro jwtFiltro) throws Exception {
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
            )
            .addFilterBefore(jwtFiltro, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}