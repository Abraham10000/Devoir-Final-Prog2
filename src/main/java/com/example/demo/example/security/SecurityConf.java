package com.example.demo.example.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConf extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/").anonymous()
                .antMatchers(HttpMethod.GET,"/users/**").hasAnyRole("boss","student")
                .antMatchers(HttpMethod.GET, "/posts/**").hasAnyRole("boss","student")
                .antMatchers(HttpMethod.POST, "/users").hasRole("boss")
                .and()
                .formLogin()
                .and()
                .logout().permitAll()
                .and()
                .csrf()
                .disable()
                .httpBasic();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Override
    protected UserDetailsService userDetailsService(){

        UserDetails student = User.builder()
                .username("Aby")
                .password(getPasswordEncoder().encode("azerty123"))
                .roles("student")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(getPasswordEncoder().encode("admin"))
                .roles("boss")
                .build();
        return new InMemoryUserDetailsManager(student,admin);
    }
}