package com.molsbee.movie.security.config;

import com.molsbee.movie.security.model.Authority;
import com.molsbee.movie.security.service.ServiceAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@ComponentScan(basePackages = {"com.molsbee.movie.security.service"})
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ServiceAccountDetails serviceAccountDetails;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                    .authorizeRequests()
                        .antMatchers("/api").hasAuthority(Authority.ADMIN.name())
                        .antMatchers("/**").hasAuthority(Authority.USER.name())
                .and()
                    .authenticationProvider(authenticationProvider()).httpBasic()
                .and()
                    .formLogin()
                        .loginPage("/login").permitAll()
                        .usernameParameter("username").passwordParameter("password")
                        .loginProcessingUrl("/login").permitAll()
                        .failureUrl("/login?error");
    }

    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(serviceAccountDetails);
        return authProvider;
    }
}
