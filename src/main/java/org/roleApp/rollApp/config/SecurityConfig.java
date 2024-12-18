package org.roleApp.rollApp.config;

import org.roleApp.rollApp.security.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import java.util.*;

import static org.roleApp.rollApp.shared.constant.ApiConstants.API_BASE_PATH;

@Configuration
@EnableWebSecurity
@Profile("dev")
public class SecurityConfig {
    private CustomAuthenticationProvider customAuthenticationProvider;


    @Autowired
    @Lazy
    private void setCustomAuthenticationProvider(CustomAuthenticationProvider customAuthenticationProvider) {
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(API_BASE_PATH + "/admin/account/{id}",
                                API_BASE_PATH + "/admin/balance/{id}",
                                API_BASE_PATH + "/admin/card/{id}",
                                API_BASE_PATH + "/admin/loan/{id}"
                                ).hasAnyRole("ADMIN, USER")
                        .requestMatchers(HttpMethod.GET, API_BASE_PATH + "/public/contact",
                                API_BASE_PATH + "/public/notification"
                        ).permitAll()
                        .requestMatchers(API_BASE_PATH + "/public/**").permitAll()
                        .requestMatchers(API_BASE_PATH + "/admin/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH, API_BASE_PATH + "/public/auth/name/{username}").hasRole("USER")
                        .anyRequest().hasRole("ADMIN")
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(httpSecurityHttpBasicConfigurer -> {
                }).formLogin()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/api/v1/auth/login?logout")
                .invalidateHttpSession(true);


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder("bcrypt", encoders);
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
        return authenticationManagerBuilder.build();
    }
}
