package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.model.Desktoplayout;
import de.jgsoftware.lanserver.model.Users;
import de.jgsoftware.lanserver.service.UserService;
import de.jgsoftware.lanserver.service.interfaces.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.List;

@RestController
public class CtrlUsers
{


    @Autowired
    iUserService userService;

    @RequestMapping("/")
    public Principal user(Principal user)
    {
        return user;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<String> getUserById(String token)
    {
        token.getBytes(StandardCharsets.UTF_8);

        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @PostMapping("/loginclientuser")
    public ResponseEntity<Users> loginclientuser(String username, String password)
    {


        String user = username.toString();
        String pass = password.toString();


        return new ResponseEntity<Users>(HttpStatus.OK);
    }


    @RequestMapping("/getUserData")
    public String getTestLogin()
    {

        return "ok test string";
    }

    @PostMapping(value = "/createuser")
    public ResponseEntity<Users> createUser(Users users)
    {


        System.out.print("es soll ein benutzer angelegt werden!");
        return createUser(users);
    }

}
