package de.jgsoftware.lanserver.service;

import de.jgsoftware.lanserver.dao.DaoOffer;
import de.jgsoftware.lanserver.dao.DaoReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class OfferService
{
    @Autowired
    DaoOffer daoOffer;

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;


    public DaoOffer getDaoOffer() {
        return daoOffer;
    }

    public void setDaoOffer(DaoOffer daoOffer) {
        this.daoOffer = daoOffer;
    }
}
