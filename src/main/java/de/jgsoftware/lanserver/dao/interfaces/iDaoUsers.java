package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.Users;

import java.util.List;

public interface iDaoUsers
{
    public List<Users> getAllUsers();
    public Users getItembyId(int id);
}
