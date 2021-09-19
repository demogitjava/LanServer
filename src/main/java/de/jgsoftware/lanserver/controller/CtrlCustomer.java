/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.controller;

import de.jgsoftware.lanserver.dto.dtoMKundenstamm;
import de.jgsoftware.lanserver.model.MKundenstamm;
import de.jgsoftware.lanserver.service.SCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CtrlCustomer 
{
    
    @Autowired
    SCustomer customerservice;

    dtoMKundenstamm dtokundenstamm;


    @GetMapping("/getCustomerbyName/{customername}")
    public ResponseEntity<List<MKundenstamm>> getUserById(@PathVariable("customername") String customername)
    {
        List<MKundenstamm> customerlist = customerservice.getDaocustomer().getCustomerbyname(customername);
        return new ResponseEntity<List<MKundenstamm>>(customerlist, HttpStatus.OK);
    }

    @PostMapping("/savenewcustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MKundenstamm> createnewcustomer(@RequestBody MKundenstamm mKundenstamm)
    {

        customerservice.getDaocustomer().save(mKundenstamm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/updatenewcustomer")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MKundenstamm> updatecustomer(@RequestBody MKundenstamm dtokundenstamm)
    {

        customerservice.getDaocustomer().UpdateCustomer(dtokundenstamm);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
