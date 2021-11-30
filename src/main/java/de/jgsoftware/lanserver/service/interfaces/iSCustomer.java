package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoCustomer;
import org.springframework.stereotype.Service;

@Service
public interface iSCustomer
{
    public DaoCustomer getDaocustomer();
    public void setDaocustomer(DaoCustomer daocustomer);
}
