package de.jgsoftware.lanserver.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.MKundenstamm;
import main.java.de.jgsoftware.lanserver.model.mawi.Buchungsdaten;

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
