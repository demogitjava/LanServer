package de.jgsoftware.lanserver.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import main.java.de.jgsoftware.lanserver.controller.interfaces.i_CtrlArtikelstamm;
import main.java.de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import main.java.de.jgsoftware.lanserver.service.interfaces.iArtikelservice;

/**
 *
 * @author hoscho
 */

@Controller
public class CtrArtikelstamm implements i_CtrlArtikelstamm
{


    @Autowired
    iArtikelservice artikelservice;


    @Override
    public ResponseEntity<List<Artikelstamm>> getAllArtikel()
    {
        List<Artikelstamm> allArikellist = artikelservice.getDartstamm().getAllArtikel();
        return new ResponseEntity<List<Artikelstamm>>(allArikellist, HttpStatus.OK);
    }


    /*
            search items over item description
            Table Artikelstamm
     */
    @Override
    public ResponseEntity<List<Artikelstamm>> getUserById(@PathVariable("bezeichnung") String bezeichnung)
    {
        List<Artikelstamm> artikelselectionclientlist = artikelservice.getDartstamm().getArtikelselectionclient(bezeichnung);
        return new ResponseEntity<List<Artikelstamm>>(artikelselectionclientlist, HttpStatus.OK);
    }


    /*
           Table Artikelstamm - selectionclient = 1
    */
    @Override
    public ResponseEntity<List<Artikelstamm>> getselectedAllArtikel()
    {
        List<Artikelstamm> selectedArikellist = artikelservice.getDartstamm().getSelectedAllArtikel();
        return new ResponseEntity<List<Artikelstamm>>(selectedArikellist, HttpStatus.OK);
    }




}
