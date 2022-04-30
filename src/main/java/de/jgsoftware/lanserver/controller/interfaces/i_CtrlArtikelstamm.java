package de.jgsoftware.lanserver.controller.interfaces;


import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/artikelstamm")
public interface i_CtrlArtikelstamm
{
    @GetMapping("/getallartikel")
    ResponseEntity<List<Artikelstamm>> getAllArtikel();

    @GetMapping("/getArtikelbyArtikelbezeichnung/{bezeichnung}")
    ResponseEntity<List<Artikelstamm>> getUserById(@PathVariable("bezeichnung") String bezeichnung);

    @GetMapping("/getselectedArtikel")
    ResponseEntity<List<Artikelstamm>> getselectedAllArtikel();
}
