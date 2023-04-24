package com.example.demo.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http
        .cors()
        .configurationSource(request -> {
          CorsConfiguration corsConfiguration = new CorsConfiguration();
          corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Set allowed origin
          corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // Set allowed methods
          corsConfiguration.setAllowedHeaders(Arrays.asList("*")); // Set allowed headers
          corsConfiguration.setAllowCredentials(true); // Allow credentials (e.g., cookies) to be included in CORS
                                                       // requests
          return corsConfiguration;
        })
        .and()
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers(new AntPathRequestMatcher("/login"))
            .permitAll()
            .requestMatchers(new AntPathRequestMatcher("/books/**"))
            .permitAll()
            .requestMatchers(new AntPathRequestMatcher("/images/**"))
            .permitAll()
            // .requestMatchers(new AntPathRequestMatcher("/images"))
            // .permitAll()
            // .requestMatchers(new AntPathRequestMatcher("/upload"))
            // .permitAll()
            .anyRequest().authenticated())
        .csrf().disable()
        .formLogin()
        .and()
        .logout() 
        .logoutUrl("/logout") 
        .logoutSuccessUrl("/login") 
        .invalidateHttpSession(true) 
        .deleteCookies("JSESSIONID");
    // .formLogin(form -> {
    // form.loginPage("/login")
    // .usernameParameter("username")
    // .passwordParameter("password");

    // });
    // .httpBasic();
    return http.build();
  }
}
