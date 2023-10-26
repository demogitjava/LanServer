package de.jgsoftware.lanserver.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.Users;
import main.java.de.jgsoftware.lanserver.model.Yourcompanydata;


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
