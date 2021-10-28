package de.jgsoftware.lanserver.dao.interfaces.mawi;

import de.jgsoftware.lanserver.model.MKundenstamm;
import java.io.Serializable;
import java.util.List;

import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import de.jgsoftware.lanserver.model.MKundenstamm;

import javax.persistence.Id;

/**
 *
 * @author hoscho
 */
@Repository
public interface CrudBuchungsdaten extends CrudRepository<Buchungsdaten, Integer>
{


}

