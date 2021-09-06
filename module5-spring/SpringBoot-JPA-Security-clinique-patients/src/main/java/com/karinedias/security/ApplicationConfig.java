package com.karinedias.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Activation de la page de login avec la route /login
        http.formLogin().loginPage("/login").defaultSuccessUrl("/all", true);
        http.authorizeRequests().antMatchers("/login", "/css/**").permitAll();
        http.authorizeRequests().antMatchers("/all").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')");
        http.authorizeRequests().antMatchers( "/add", "/edit/**", "/delete/**", "/updateForm/**", "/add-new", "/users").hasRole("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/login.html");
    }
}
