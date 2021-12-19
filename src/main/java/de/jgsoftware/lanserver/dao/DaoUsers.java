
package de.jgsoftware.lanserver.dao;

import de.jgsoftware.lanserver.dao.interfaces.iDaoUsers;
import de.jgsoftware.lanserver.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoUsers implements iDaoUsers
{


    @Autowired
    @Qualifier("defaultJdbcTemplate")
    private JdbcTemplate jtm;

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

}