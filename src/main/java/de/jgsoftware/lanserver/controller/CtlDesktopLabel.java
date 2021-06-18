package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.model.Desktoplayout;
import de.jgsoftware.lanserver.service.LoginWindowService;
import de.jgsoftware.lanserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


// /detaillabeldesktopentry/getloginlabel
@RestController
public class CtlDesktopLabel
{

    @Autowired
    de.jgsoftware.lanserver.service.LoginWindowService loginWindowService;

    @GetMapping("/detaillabeldesktopentry/getloginlabel")
    public ResponseEntity<List<Desktoplayout>> getWindowEntitys()
    {
        return new ResponseEntity<List<Desktoplayout>>(loginWindowService.getLoginWindow().getlogintextentry(), HttpStatus.OK);
    }

}
