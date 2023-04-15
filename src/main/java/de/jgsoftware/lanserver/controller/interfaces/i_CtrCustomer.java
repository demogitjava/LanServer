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

@RequestMapping("/customer")
public interface i_CtrCustomer
{


    @GetMapping("/getCustomerbyName/{customername}")
    ResponseEntity<List<MKundenstamm>> getUserById(@PathVariable("customername") String customername);

    @PostMapping("/savenewcustomer")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<MKundenstamm> createnewcustomer(@RequestBody MKundenstamm mKundenstamm);


    @PostMapping("/updatenewcustomer")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<MKundenstamm> updatecustomer(@RequestBody MKundenstamm dtokundenstamm);

    @GetMapping("/newCustomer")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<MKundenstamm>> getnewcustomer();

    @PostMapping("/deletecustomer")
    MKundenstamm deleteCustomer(@RequestBody MKundenstamm dtokundenstamm);

    @GetMapping("/getcustomerdocuments/{customernumber}")
    ResponseEntity<List<Buchungsdaten>> getcustomerdocuments(@PathVariable("customernumber") String customernumber);



}
