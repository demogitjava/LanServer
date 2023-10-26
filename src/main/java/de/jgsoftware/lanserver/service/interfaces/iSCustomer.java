package de.jgsoftware.lanserver.service.interfaces;

import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoCustomer;

/**
 *
 * @author hoscho
 */

@Service
public interface iSCustomer
{
    DaoCustomer getDaocustomer();
    void setDaocustomer(DaoCustomer daocustomer);


}
