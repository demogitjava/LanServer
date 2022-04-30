package de.jgsoftware.lanserver.service.interfaces;


import de.jgsoftware.lanserver.dao.DaoUsers;
import de.jgsoftware.lanserver.model.Yourcompanydata;
import org.springframework.stereotype.Service;

@Service
public interface iUserService
{
    DaoUsers getDuser();
    void setDuser(DaoUsers duser);


}
