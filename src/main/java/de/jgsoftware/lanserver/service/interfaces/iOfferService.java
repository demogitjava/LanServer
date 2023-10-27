package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoOffer;
import org.springframework.stereotype.Service;

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
