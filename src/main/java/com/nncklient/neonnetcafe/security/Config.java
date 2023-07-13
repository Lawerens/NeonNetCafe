package com.nncklient.neonnetcafe.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class Config {

    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .requestMatchers("/css/**", "/js/**");
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails szymon = User.builder()
//                .username("szymon")
//                .password("{noop}test123")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails kamil = User.builder()
//                .username("kamil")
//                .password("{noop}test123")
//                .roles("OBSLUGA")
//                .build();
//
//        return new InMemoryUserDetailsManager(szymon, kamil);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/css/**").permitAll()
                                .requestMatchers("/images/**").permitAll()
                                .requestMatchers("/klienci/rejestracja").permitAll()
                                .requestMatchers("/klienci/save").permitAll()
                                .requestMatchers("/klient/**").hasRole("OBSLUGA, ADMIN")
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()

                )
                .formLogin(form ->
                        form

                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .defaultSuccessUrl("/zalogowany", true)
                                .permitAll()

                )
                .logout(logout ->
                        logout
                                .permitAll()
                                .logoutSuccessUrl("/login")
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                )
        ;

        return http.build();
    }
}
