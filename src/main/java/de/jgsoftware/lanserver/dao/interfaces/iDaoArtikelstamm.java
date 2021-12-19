package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.mawi.Artikelstamm;

import java.util.List;

public interface iDaoArtikelstamm
{
    public List<Artikelstamm> getAllArtikel();
    public List<Artikelstamm> getArtikelselectionclient(String bezeichnung);
    public List<Artikelstamm> getSelectedAllArtikel();
}
