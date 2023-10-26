package de.jgsoftware.lanserver.service.interfaces;


import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoUsers;
/**
 *
 * @author hoscho
 */
@Service
public interface iUserService
{
    DaoUsers getDuser();
    void setDuser(DaoUsers duser);


}
