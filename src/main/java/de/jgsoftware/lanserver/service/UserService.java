package de.jgsoftware.lanserver.service;


import de.jgsoftware.lanserver.dao.DaoUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements de.jgsoftware.lanserver.service.interfaces.iUserService
{

    @Autowired
    DaoUsers duser;

    public UserService()
    {

    }

    public DaoUsers getDuser() {
        return duser;
    }

    public void setDuser(DaoUsers duser) {
        this.duser = duser;
    }
}
