
package de.jgsoftware.lanserver.dao;

import de.jgsoftware.lanserver.dao.interfaces.iDaoCrudRepositoryYourCompanydata;
import de.jgsoftware.lanserver.dao.interfaces.iDaoUsers;
import de.jgsoftware.lanserver.model.Users;
import de.jgsoftware.lanserver.model.Yourcompanydata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DaoUsers implements iDaoUsers {


    @Autowired
    @Qualifier("defaultJdbcTemplate")
    private JdbcTemplate jtm;


    @Autowired
    iDaoCrudRepositoryYourCompanydata idaoCrudrepYourCompanydata;

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


    public Yourcompanydata edityourcompanydata(Yourcompanydata ycomdata)
    {


        return idaoCrudrepYourCompanydata.save(ycomdata);
    }

}