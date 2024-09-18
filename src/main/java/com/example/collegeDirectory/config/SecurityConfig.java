package com.example.collegeDirectory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/auth/login").permitAll() // Allow public access to the home page
                .requestMatchers("/api/v1/auth/register").permitAll() // Allow public access to the home page
                .requestMatchers("/api/v1/students/**").hasRole("STUDENT") // Student endpoints
                .requestMatchers("/api/v1/faculty/**").hasRole("FACULTY_MEMBER") // Faculty endpoints
                .requestMatchers("/api/v1/admin/**").hasRole("ADMINISTRATOR") // Admin endpoints
                .anyRequest().authenticated() // Require authentication for all other requests
            )
            .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session management
            .httpBasic(); // Use HTTP Basic authentication

        return http.build();
    }

    @Bean
    public UserDetails createNewUser() {
        PasswordEncoder passwordEncoder = passwordEncoder();
        String encodedPassword = passwordEncoder.encode("vishnu"); // Replace with a secure password

        return User.builder()
            .username("vishnu") // Replace with the desired username
            .password(encodedPassword)
            .roles("STUDENT") // Assign role(s) as needed (e.g., STUDENT, FACULTY_MEMBER, ADMINISTRATOR)
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
    }
}