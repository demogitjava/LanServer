package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoCustomer;
import de.jgsoftware.lanserver.dao.interfaces.iDaoCustomer;
import org.springframework.stereotype.Service;

@Service
public interface iSCustomer
{
    DaoCustomer getDaocustomer();
    void setDaocustomer(DaoCustomer daocustomer);


}
