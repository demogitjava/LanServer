package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class CtrlUsers
{


    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public Principal user(Principal user)
    {
        return user;
    }

}
