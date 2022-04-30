package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iDaoArtikelstamm
{
    List<Artikelstamm> getAllArtikel();
    List<Artikelstamm> getArtikelselectionclient(String bezeichnung);
    List<Artikelstamm> getSelectedAllArtikel();
}
