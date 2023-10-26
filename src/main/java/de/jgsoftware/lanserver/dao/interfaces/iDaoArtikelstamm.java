package de.jgsoftware.lanserver.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.mawi.Artikelstamm;


/**
 *
 * @author hoscho
 */
@Repository
public interface iDaoArtikelstamm
{
    List<Artikelstamm> getAllArtikel();
    List<Artikelstamm> getArtikelselectionclient(String bezeichnung);
    List<Artikelstamm> getSelectedAllArtikel();
}
