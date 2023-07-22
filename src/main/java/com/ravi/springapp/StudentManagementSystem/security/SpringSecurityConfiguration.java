package com.ravi.springapp.StudentManagementSystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // indicates one or more bean methods processed by spring for bean defination
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        // 1 All request should be Aunthecited
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
                );
       http.httpBasic(Customizer.withDefaults());

        http.csrf().disable();
        return http.build();
    }
}
