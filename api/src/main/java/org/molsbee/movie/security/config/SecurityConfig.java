package org.molsbee.movie.security.config;

import org.molsbee.movie.security.model.Authority;
import org.molsbee.movie.security.service.ServiceAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"org.molsbee.movie.security.service"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ServiceAccountDetails serviceAccountDetails;

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity
                .ignoring()
                .antMatchers("/css")
                .antMatchers("/fonts")
                .antMatchers("/img")
                .antMatchers("/js");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                    .authorizeRequests()
                        .antMatchers("/**").hasAuthority(Authority.USER.name())
                        .antMatchers("/api").hasAuthority(Authority.ADMIN.name())
                .and()
                    .authenticationProvider(authenticationProvider()).httpBasic()
                .and()
                    .formLogin()
                        .loginPage("/login").permitAll()
                        .usernameParameter("username").passwordParameter("password")
                        .loginProcessingUrl("/login").permitAll()
                        .failureUrl("/login?error");
    }

    @Bean(name = "MovieAuthProvider")
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(serviceAccountDetails);
        return authProvider;
    }
}
