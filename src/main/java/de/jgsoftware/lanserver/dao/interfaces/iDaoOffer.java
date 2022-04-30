package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iDaoOffer {
    List<Buchungsdaten> savenewOffer(List<Buchungsdaten> buchungsdaten);

    Integer getIdfromtable(Integer rowidforsave);

    List<Artikelstamm> getartikelkenzeichen(Long artikelnummer);

    List<Buchungsdaten> additemstooffercache(Buchungsdaten buchdat);

    List<Buchungsdaten> getOffercachelist();
    void setOffercachelist(List<Buchungsdaten> offercachelist);
}
