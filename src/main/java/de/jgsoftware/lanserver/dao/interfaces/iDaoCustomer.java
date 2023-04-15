package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.MKundenstamm;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author hoscho
 */

@Repository
public interface iDaoCustomer
{
    List<MKundenstamm> getCustomerbyname(String customername);
    MKundenstamm UpdateCustomer(MKundenstamm dtokundenstamm);
    MKundenstamm save(MKundenstamm mKundenstamm);
    List createnewCustomer();
    MKundenstamm deleteCusomter(MKundenstamm dtokundenstamm);
    List<Buchungsdaten> getDocumentsforcustomer(String customernumber);
}
