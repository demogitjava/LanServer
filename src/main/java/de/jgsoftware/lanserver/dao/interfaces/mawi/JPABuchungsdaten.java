package de.jgsoftware.lanserver.dao.interfaces.mawi;


import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPABuchungsdaten extends JpaRepository<Buchungsdaten, Integer> {

}
