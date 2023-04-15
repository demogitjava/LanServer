package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hoscho
 */
@Repository
public interface iDaoUsersCrud extends CrudRepository<Users, Integer> {
}
