package de.jgsoftware.lanserver.dao.interfaces.mawi;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
/**
 *
 * @author hoscho
 */
@Repository
public interface JPABuchungsdaten extends JpaRepository<Buchungsdaten, Integer>
{

}
