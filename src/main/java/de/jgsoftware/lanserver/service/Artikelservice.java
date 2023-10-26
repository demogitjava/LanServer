package de.jgsoftware.lanserver.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoArtikelstamm;
/**
 *
 * @author hoscho
 */
@Service
public class Artikelservice implements de.jgsoftware.lanserver.service.interfaces.iArtikelservice
{

    @Autowired
    DaoArtikelstamm dartstamm;

    public Artikelservice(DaoArtikelstamm dartstamm)
    {

    }

    @Override
    public DaoArtikelstamm getDartstamm() {
        return dartstamm;
    }
    @Override
    public void setDartstamm(DaoArtikelstamm dartstamm) {
        this.dartstamm = dartstamm;
    }
}
