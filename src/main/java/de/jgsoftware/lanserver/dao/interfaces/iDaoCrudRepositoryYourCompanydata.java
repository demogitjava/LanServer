package de.jgsoftware.lanserver.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.Yourcompanydata;

/**
 *
 * @author hoscho
 */

@Repository
public interface iDaoCrudRepositoryYourCompanydata extends JpaRepository<Yourcompanydata, Integer> {
}
