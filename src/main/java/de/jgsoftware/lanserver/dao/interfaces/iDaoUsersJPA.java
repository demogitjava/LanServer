package de.jgsoftware.lanserver.dao.interfaces;


import de.jgsoftware.lanserver.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author hoscho
 */
@Repository
public interface iDaoUsersJPA extends JpaRepository<Users, Integer> {
}
