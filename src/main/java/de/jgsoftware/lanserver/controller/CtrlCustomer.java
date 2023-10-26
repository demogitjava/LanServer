/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import main.java.de.jgsoftware.lanserver.controller.interfaces.i_CtrCustomer;
import main.java.de.jgsoftware.lanserver.dto.dtoMKundenstamm;
import main.java.de.jgsoftware.lanserver.model.MKundenstamm;
import main.java.de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import main.java.de.jgsoftware.lanserver.service.interfaces.iSCustomer;

/**
 *
 * @author hoscho
 */

@Controller
public class CtrlCustomer implements i_CtrCustomer
{

    @Qualifier("SCustomer")
    @Autowired
    iSCustomer customerservice;

    @Autowired
    dtoMKundenstamm dtokundenstamm;


    @Override
    public ResponseEntity<List<MKundenstamm>> getUserById(@PathVariable("customername") String customername)
    {
        List<MKundenstamm> customerlist = customerservice.getDaocustomer().getCustomerbyname(customername);
        return new ResponseEntity<List<MKundenstamm>>(customerlist, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MKundenstamm> createnewcustomer(@RequestBody MKundenstamm mKundenstamm)
    {

        customerservice.getDaocustomer().save(mKundenstamm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<MKundenstamm> updatecustomer(@RequestBody MKundenstamm dtokundenstamm)
    {

        customerservice.getDaocustomer().UpdateCustomer(dtokundenstamm);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<MKundenstamm>> getnewcustomer()
    {
        List<MKundenstamm> newcustomerlist = customerservice.getDaocustomer().createnewCustomer();
        return new ResponseEntity<List<MKundenstamm>>(newcustomerlist, HttpStatus.OK);
    }

    @Override
    public MKundenstamm deleteCustomer(@RequestBody MKundenstamm dtokundenstamm)
    {

        return customerservice.getDaocustomer().deleteCusomter(dtokundenstamm);
    }


    /*
            return all documents
            from customer
            with year and the last 4 month
     */
    @Override
    public ResponseEntity<List<Buchungsdaten>> getcustomerdocuments(@PathVariable("customernumber") String customernumber)
    {
        List<Buchungsdaten> dokumentlist = customerservice.getDaocustomer().getDocumentsforcustomer(customernumber);
        return new ResponseEntity<List<Buchungsdaten>>(dokumentlist, HttpStatus.OK);
    }



}
