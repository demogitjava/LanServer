package de.jgsoftware.lanserver.service.interfaces;

import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoOffer;

/**
 *
 * @author hoscho
 */

@Service
public interface iOfferService
{
    DaoOffer getDaoOffer();
    void setDaoOffer(DaoOffer daoOffer);

}
