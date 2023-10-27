package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.Users;
import de.jgsoftware.lanserver.model.Yourcompanydata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 *
 * @author hoscho
 */

@Repository
public interface iDaoUsers
{
    List<Users> getAllUsers();
    Users getItembyId(int id);
    List getYourCompanydata();
    List getAllUserdata();
    Users edituser(Users users);
    Users createnewuser(Users users);

    Integer deleteusers(Integer id);
    Yourcompanydata edityourcompanydata(Yourcompanydata ycomdata);
}
