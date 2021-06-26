package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.model.Desktoplayout;
import de.jgsoftware.lanserver.model.Users;
import de.jgsoftware.lanserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.List;

@Controller
public class CtrlUsers
{


    @Autowired
    UserService userService;

    @RequestMapping("/")
    public Principal user(Principal user)
    {
        return user;
    }

    @GetMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<String> getUserById(String token)
    {
        token.getBytes(StandardCharsets.UTF_8);

        return new ResponseEntity<String>("success", HttpStatus.OK);
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
