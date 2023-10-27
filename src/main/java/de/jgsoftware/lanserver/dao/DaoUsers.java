
package de.jgsoftware.lanserver.dao;

import de.jgsoftware.lanserver.dao.interfaces.iDaoCrudRepositoryYourCompanydata;
import de.jgsoftware.lanserver.dao.interfaces.iDaoUsers;
import de.jgsoftware.lanserver.dao.interfaces.iDaoUsersCrud;
import de.jgsoftware.lanserver.dao.interfaces.iDaoUsersJPA;
import de.jgsoftware.lanserver.model.Users;
import de.jgsoftware.lanserver.model.Yourcompanydata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author hoscho
 */

@Repository
public class DaoUsers implements iDaoUsers {


    @Autowired
    @Qualifier("defaultJdbcTemplate")
    private JdbcTemplate jtm;


    @Autowired
    iDaoCrudRepositoryYourCompanydata idaoCrudrepYourCompanydata;

    @Autowired
    iDaoUsersJPA idaouserjpa;

    @Autowired
    iDaoUsersCrud idaousercrud;



    @Override
    public List<Users> getAllUsers()
    {
        List<Users> demousers = jtm.query("select * from users", new BeanPropertyRowMapper(Users.class));
        return demousers;
    }

    @Override
    public Users getItembyId(int id)
    {
        Users users = (Users) jtm.query("SELECT * FROM USERS WHERE ID=?", new BeanPropertyRowMapper(Users.class));
        return users;
    }

    @Override
    public List getYourCompanydata()
    {
        List yourcompanydata = jtm.query("select * from YOURCOMPANYDATA", new BeanPropertyRowMapper(Yourcompanydata.class));
        return yourcompanydata;
    }


    @Override
    public List getAllUserdata()
    {
        List userdata = jtm.query("select * from USERS", new BeanPropertyRowMapper(Users.class));
        return userdata;
    }

    @Override
    public Yourcompanydata edityourcompanydata(Yourcompanydata ycomdata)
    {
     return idaoCrudrepYourCompanydata.save(ycomdata);
    }


     // new user
     @Override
     public Users createnewuser(Users users)
     {
         Long newiduser = idaouserjpa.count();
         users.setId(newiduser +1);
         users.setEnabled(1);
         return idaouserjpa.save(users);
     }


     // edit
     @Override
     public Users edituser(Users users)
     {
         return idaousercrud.save(users);
     }

    // delete
    @Override
    public Integer deleteusers(Integer id)
    {
        jtm.execute("DELETE FROM USERS where ID=" + id);
        return id;
    }



}