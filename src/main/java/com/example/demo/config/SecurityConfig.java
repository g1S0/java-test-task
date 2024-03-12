package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/posts/**").hasRole("POSTS")
                        .requestMatchers("/users/**").hasRole("USERS")
                        .requestMatchers("/albums/**").hasRole("ALBUMS")
                        .requestMatchers("/posts/**").hasRole("ADMIN")
                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .requestMatchers("/albums/**").hasRole("ADMIN")
                ).httpBasic(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("admin").password("password").roles("ADMIN", "POSTS", "USERS", "ALBUMS").build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("postUser").password("password").roles("POSTS").build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("albumUser").password("password").roles("ALBUMS").build());
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("userUser").password("password").roles("USERS").build());
        return manager;
    }
}



