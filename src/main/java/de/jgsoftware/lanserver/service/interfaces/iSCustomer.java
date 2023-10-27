package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoCustomer;
import de.jgsoftware.lanserver.dao.interfaces.iDaoCustomer;
import org.springframework.stereotype.Service;

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
