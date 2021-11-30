package de.jgsoftware.lanserver.service.interfaces;


import de.jgsoftware.lanserver.dao.DaoUsers;
import org.springframework.stereotype.Service;

@Service
public interface iUserService
{
    public DaoUsers getDuser();
    public void setDuser(DaoUsers duser);
}
