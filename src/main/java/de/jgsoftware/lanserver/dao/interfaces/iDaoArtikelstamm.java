package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iDaoArtikelstamm
{
    public List<Artikelstamm> getAllArtikel();
    public List<Artikelstamm> getArtikelselectionclient(String bezeichnung);
    public List<Artikelstamm> getSelectedAllArtikel();
}
