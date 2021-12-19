package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iDaoOffer {
    public List<Buchungsdaten> savenewOffer(List<Buchungsdaten> buchungsdaten);

    public Integer getIdfromtable(Integer rowidforsave);

    public List<Artikelstamm> getartikelkenzeichen(Long artikelnummer);

    public List<Buchungsdaten> additemstooffercache(Buchungsdaten buchdat);

    public List<Buchungsdaten> getOffercachelist();
    public void setOffercachelist(List<Buchungsdaten> offercachelist);
}
