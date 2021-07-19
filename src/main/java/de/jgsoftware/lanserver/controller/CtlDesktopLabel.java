package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.model.Desktoplayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


// /detaillabeldesktopentry/getloginlabel
@Controller
@RequestMapping("/detaillabeldesktopentry")
public class CtlDesktopLabel
{

    @Autowired
    de.jgsoftware.lanserver.service.LoginWindowService loginWindowService;


    /*
        List with Text
        for Login JInternalFrame only
     */
    @GetMapping("/getloginlabel")
    public ResponseEntity<List<Desktoplayout>> getLoginEntry()
    {
        List<Desktoplayout> deskloginentry = loginWindowService.getLoginWindow().getlogintextentry();
        return new ResponseEntity<List<Desktoplayout>>(deskloginentry, HttpStatus.OK);
    }



    /*
        return Text Entry
        for Desktop Frame

        over String for framename
     */
    @GetMapping("/getloginlabel/{framename}")
    public ResponseEntity<List<Desktoplayout>> getUserById(@PathVariable("framename") String framename)
    {
        List<Desktoplayout> deskloginentry = loginWindowService.getLoginWindow().getFrameDesktopEntry(framename);
        return new ResponseEntity<List<Desktoplayout>>(deskloginentry, HttpStatus.OK);
    }

}
