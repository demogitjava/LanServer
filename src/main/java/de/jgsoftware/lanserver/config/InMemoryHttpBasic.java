package de.jgsoftware.lanserver.config;


import de.jgsoftware.lanserver.model.Users;
import de.jgsoftware.lanserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.Filter;

import java.util.ArrayList;
import java.util.ListIterator;

@Configuration
@EnableWebSecurity
public class InMemoryHttpBasic extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    public ArrayList<Users> memusers;

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

        System.out.print("users from database" + "\n");


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("username")
                .password(encoder.encode("password"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("admin"))
                .roles("USER", "ADMIN");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/detaillabeldesktopentry/getloginlabel");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }



}
