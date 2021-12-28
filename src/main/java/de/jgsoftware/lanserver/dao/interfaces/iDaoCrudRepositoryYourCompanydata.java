package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.Yourcompanydata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iDaoCrudRepositoryYourCompanydata extends CrudRepository<Yourcompanydata, Integer> {
}
