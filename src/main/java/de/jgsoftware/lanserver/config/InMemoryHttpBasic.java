package de.jgsoftware.lanserver.config;


import de.jgsoftware.lanserver.model.Users;
import de.jgsoftware.lanserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.Filter;

import java.util.ArrayList;
import java.util.ListIterator;

@Configuration
@EnableWebSecurity
public class InMemoryHttpBasic extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    public ArrayList<Users> memusers;

    WebSecurity web;

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic()
                .authenticationEntryPoint(authEntryPoint);
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {

        memusers = (ArrayList<Users>) userService.getDuser().getAllUsers();

        for (ListIterator<Users> iter = memusers.listIterator(); iter.hasNext(); )
        {
            Users element = iter.next();

            Integer id = element.getId();
            String email = element.getEmail();
            String password = element.getPassword();
            String role = element.getRole();
            String username = element.getUsername();


            auth.inMemoryAuthentication().withUser(username).password(password).roles(role);

        }

        System.out.print("User are loaded in Memory for Http Basic Auth" + "\n");


    }

    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/detaillabeldesktopentry/**");
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }





}
