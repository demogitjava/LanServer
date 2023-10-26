package de.jgsoftware.lanserver.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import main.java.de.jgsoftware.lanserver.model.mawi.Buchungsdaten;


/**
 *
 * @author hoscho
 */

@Repository
public interface iDaoOffer {
    List<Buchungsdaten> savenewOffer(List<Buchungsdaten> buchungsdaten);

    Integer getIdfromtable(Integer rowidforsave);

    List<Artikelstamm> getartikelkenzeichen(Long artikelnummer);

    List<Buchungsdaten> additemstooffercache(Buchungsdaten buchdat);

    List<Buchungsdaten> getOffercachelist();
    void setOffercachelist(List<Buchungsdaten> offercachelist);
}
