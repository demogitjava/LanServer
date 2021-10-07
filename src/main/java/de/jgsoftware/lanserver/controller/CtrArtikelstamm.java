package de.jgsoftware.lanserver.controller;



import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Controller
@RequestMapping("/artikelstamm")
public class CtrArtikelstamm
{


    @Autowired
    de.jgsoftware.lanserver.service.Artikelservice artikelservice;


    @GetMapping("/getallartikel")
    public ResponseEntity<List<Artikelstamm>> getAllArtikel()
    {
        List<Artikelstamm> allArikellist = artikelservice.getDartstamm().getAllArtikel();
        return new ResponseEntity<List<Artikelstamm>>(allArikellist, HttpStatus.OK);
    }
}
