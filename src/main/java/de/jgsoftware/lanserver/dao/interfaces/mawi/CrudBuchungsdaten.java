package de.jgsoftware.lanserver.dao.interfaces.mawi;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.mawi.Buchungsdaten;

/**
 *
 * @author hoscho
 */
@Repository
public interface CrudBuchungsdaten extends CrudRepository<Buchungsdaten, Integer>
{


}

