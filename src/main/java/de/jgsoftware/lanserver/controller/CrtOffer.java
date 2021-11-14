package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/offer")
public class CrtOffer
{

    @Autowired
    de.jgsoftware.lanserver.service.OfferService offerService;

    public CrtOffer()
    {

    }


    @PostMapping("/savenewoffer")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Buchungsdaten>> createnewcustomer(@RequestBody List<Buchungsdaten> buchungsdaten) {


        System.out.print("Cachelist is empty " + "\n");
        buchungsdaten = offerService.getDaoOffer().savenewOffer(buchungsdaten);

        return new ResponseEntity<List<Buchungsdaten>>(buchungsdaten, HttpStatus.OK);

    }



}
