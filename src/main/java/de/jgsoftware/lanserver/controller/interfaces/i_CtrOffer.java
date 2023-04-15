package de.jgsoftware.lanserver.controller.interfaces;


import de.jgsoftware.lanserver.model.MKundenstamm;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
