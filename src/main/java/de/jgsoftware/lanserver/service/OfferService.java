package de.jgsoftware.lanserver.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoOffer;
import main.java.de.jgsoftware.lanserver.dao.interfaces.iDaoOffer;
/**
 *
 * @author hoscho
 */
@Service
public class OfferService implements de.jgsoftware.lanserver.service.interfaces.iOfferService
{
    @Autowired
    DaoOffer daoOffer;

    @Autowired
    EntityManagerFactoryBuilder builder;

    @Autowired
    DataSource dataSource;


    iDaoOffer idaooffer;

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;

    public OfferService()
    {

    }


    /*
          functions over interface
     */
    public iDaoOffer getIdaooffer() {
        return idaooffer;
    }
    public void setIdaooffer(iDaoOffer idaooffer) {
        this.idaooffer = idaooffer;
    }

    @Override
    public DaoOffer getDaoOffer() {
        return daoOffer;
    }
    @Override
    public void setDaoOffer(DaoOffer daoOffer) {
        this.daoOffer = daoOffer;
    }
}
