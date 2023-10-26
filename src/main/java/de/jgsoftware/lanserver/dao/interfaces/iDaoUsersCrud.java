package de.jgsoftware.lanserver.dao.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.Users;

/**
 *
 * @author hoscho
 */
@Repository
public interface iDaoUsersCrud extends CrudRepository<Users, Integer> {
}
