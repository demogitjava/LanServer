package de.jgsoftware.lanserver.controller.interfaces;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import main.java.de.jgsoftware.lanserver.model.mawi.Buchungsdaten;

/**
 *
 * @author hoscho
 */

@RequestMapping("/offer")
public interface i_CtrOffer
{
    @PostMapping("/savenewoffer")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<List<Buchungsdaten>> createnewcustomer(@RequestBody List<Buchungsdaten> buchungsdaten);

}
