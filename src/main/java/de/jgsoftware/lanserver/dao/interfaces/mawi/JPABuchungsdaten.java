package de.jgsoftware.lanserver.dao.interfaces.mawi;


import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.jgsoftware.lanserver.config.MaWiDBConfig;
/**
 *
 * @author hoscho
 */
@Repository
public interface JPABuchungsdaten extends JpaRepository<Buchungsdaten, Integer>
{

}
