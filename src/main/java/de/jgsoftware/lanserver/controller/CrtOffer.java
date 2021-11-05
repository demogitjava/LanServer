package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offer")
public class CrtOffer
{

    @Autowired
    de.jgsoftware.lanserver.service.OfferService offerService;


    @PostMapping("/savenewoffer")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Buchungsdaten> createnewcustomer(@RequestBody List<Buchungsdaten> buchungsdaten)
    {
        return offerService.getDaoOffer().savenewOffer(buchungsdaten);
    }

}
