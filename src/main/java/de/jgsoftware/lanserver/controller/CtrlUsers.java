package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CtrlUsers
{


    @Autowired
    UserService userService;



}
