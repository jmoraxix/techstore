package com.techstore.web.config;

import java.util.Optional;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    String[] resources = new String[]{
            "/static/**", "/img/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(resources).permitAll()
               //.antMatchers("/", "/index").permitAll()
                .antMatchers("/admin*").access("hasRole('ADMIN')")
                .antMatchers("/*").access("hasRole('CLIENTE') or hasRole('ADMIN')")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    //.loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error=true")
                    .usernameParameter("nombreUsuario")
                    .passwordParameter("contrasena")
                    .and()
                    .logout()
                    .permitAll()
                    .logoutSuccessUrl("/login?logout");
    }


}
