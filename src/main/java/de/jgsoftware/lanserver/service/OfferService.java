package de.jgsoftware.lanserver.service;

import de.jgsoftware.lanserver.dao.DaoOffer;
import de.jgsoftware.lanserver.dao.DaoReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Service
public class OfferService
{
    @Autowired
    DaoOffer daoOffer;

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;

    @Qualifier("mawiJdbcTemplate")
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;



    public DaoOffer getDaoOffer() {
        return daoOffer;
    }

    public void setDaoOffer(DaoOffer daoOffer) {
        this.daoOffer = daoOffer;
    }
}
