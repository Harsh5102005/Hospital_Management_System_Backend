package com.hospital.system.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@RequiredArgsConstructor
public class WebSecurity {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf(csrfConfig -> csrfConfig.disable())
                        .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth->auth


                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/doctors/**").hasAnyRole("Doctor","Admin")
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
