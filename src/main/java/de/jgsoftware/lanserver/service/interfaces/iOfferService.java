package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoOffer;
import org.springframework.stereotype.Service;

@Service
public interface iOfferService
{
    public DaoOffer getDaoOffer();
    public void setDaoOffer(DaoOffer daoOffer);

}
