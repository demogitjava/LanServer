package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iDaoUsers
{
    public List<Users> getAllUsers();
    public Users getItembyId(int id);
    public List getYourCompanydata();
}
