package de.jgsoftware.lanserver.service.interfaces;

import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoArtikelstamm;

/**
 *
 * @author hoscho
 */
@Service
public interface iArtikelservice
{
    DaoArtikelstamm getDartstamm();
    void setDartstamm(DaoArtikelstamm dartstamm);
}
