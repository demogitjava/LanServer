package de.jgsoftware.lanserver.config;


import de.jgsoftware.lanserver.model.Users;
import de.jgsoftware.lanserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.servlet.Filter;

import java.util.ArrayList;
import java.util.ListIterator;

@Configuration
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
    protected void configure(HttpSecurity http) throws Exception {
        // protect all resources
        http.authorizeRequests().anyRequest().fullyAuthenticated();
        // protect with http basic authentication
        http.httpBasic();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/detaillabeldesktopentry/getloginlabel");
    }


}
