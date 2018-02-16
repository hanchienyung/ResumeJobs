package com.cy.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled =  true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private com.example.demo.SSUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new com.example.demo.SSUserDetailsService(userRepository);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http
                .authorizeRequests()
                .antMatchers("/addsumm/**", "/addcontact/**", "/addedu/**", "/addskills/**", "/addexp/**", "addreference/**").access("hasRole('APPLICANT')")
                .and()
                .formLogin().loginPage("/login").permitAll()
               // .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .httpBasic();

        http
                .csrf().disable();
        http
                .headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .userDetailsService(userDetailsServiceBean());
    }

}
