package de.jgsoftware.lanserver.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jgsoftware.lanserver.dao.DaoArtikelstamm;

@Service
public class Artikelservice
{

    @Autowired
    DaoArtikelstamm dartstamm;


    public DaoArtikelstamm getDartstamm() {
        return dartstamm;
    }

    public void setDartstamm(DaoArtikelstamm dartstamm) {
        this.dartstamm = dartstamm;
    }
}
