package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoArtikelstamm;
import org.springframework.stereotype.Service;

@Service
public interface iArtikelservice
{
    DaoArtikelstamm getDartstamm();
    void setDartstamm(DaoArtikelstamm dartstamm);
}
