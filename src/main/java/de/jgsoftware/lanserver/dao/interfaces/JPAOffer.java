package de.jgsoftware.lanserver.dao.interfaces;


import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JPAOffer extends JpaRepository<Buchungsdaten, Integer> {

}
