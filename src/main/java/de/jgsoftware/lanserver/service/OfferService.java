package de.jgsoftware.lanserver.service;

import de.jgsoftware.lanserver.config.MaWiDBConfig;
import de.jgsoftware.lanserver.dao.DaoOffer;
import de.jgsoftware.lanserver.dao.interfaces.iDaoOffer;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

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
