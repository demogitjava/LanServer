package de.jgsoftware.lanserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoUsers;
/**
 *
 * @author hoscho
 */
@Service
public class UserService implements de.jgsoftware.lanserver.service.interfaces.iUserService
{

    @Autowired
    DaoUsers duser;

    public UserService()
    {

    }
    @Override
    public DaoUsers getDuser() {
        return duser;
    }
    @Override
    public void setDuser(DaoUsers duser) {
        this.duser = duser;
    }
}
