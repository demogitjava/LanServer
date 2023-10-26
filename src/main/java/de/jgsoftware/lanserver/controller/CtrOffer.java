package de.jgsoftware.lanserver.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import main.java.de.jgsoftware.lanserver.controller.interfaces.i_CtrOffer;
import main.java.de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import main.java.de.jgsoftware.lanserver.service.interfaces.iOfferService;

/**
 *
 * @author hoscho
 */

@Controller
public class CtrOffer implements i_CtrOffer
{

    @Autowired
    iOfferService offerService;

    public CtrOffer()
    {

    }


    @Override
    public ResponseEntity<List<Buchungsdaten>> createnewcustomer(@RequestBody List<Buchungsdaten> buchungsdaten)
    {


        System.out.print("Cachelist is empty " + "\n");
        buchungsdaten = offerService.getDaoOffer().savenewOffer(buchungsdaten);

        return new ResponseEntity<List<Buchungsdaten>>(buchungsdaten, HttpStatus.OK);

    }



}
