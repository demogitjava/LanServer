package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.MKundenstamm;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iDaoCustomer
{
    public List<MKundenstamm> getCustomerbyname(String customername);
    public MKundenstamm UpdateCustomer(MKundenstamm dtokundenstamm);
    public MKundenstamm save(MKundenstamm mKundenstamm);
    public List createnewCustomer();
    public MKundenstamm deleteCusomter(MKundenstamm dtokundenstamm);
}