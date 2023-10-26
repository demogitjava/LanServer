package de.jgsoftware.lanserver.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.dao.interfaces.iDaoArtikelstamm;
import main.java.de.jgsoftware.lanserver.model.mawi.Artikelstamm;

/**
 *
 * @author hoscho
 */

@Repository
public class DaoArtikelstamm implements iDaoArtikelstamm
{



    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;


    public DaoArtikelstamm()
    {


    }


    @Override
    public List<Artikelstamm> getAllArtikel()
    {

        List<Artikelstamm> allartikellist = jtm1.query("select * from ARTIKELSTAMM", new BeanPropertyRowMapper(Artikelstamm.class));
        return allartikellist;
    }

    @Override
    public List<Artikelstamm> getArtikelselectionclient(String bezeichnung)
    {
        String beginswith = bezeichnung + "%";
        List<Artikelstamm> arikelclientselection = jtm1.query("select * from artikelstamm where artikelbezeichnung like " + "'" + beginswith + "'", new BeanPropertyRowMapper(Artikelstamm.class));
        return arikelclientselection;
    }

    @Override
    public List<Artikelstamm> getSelectedAllArtikel()
    {
        Integer selectionnumber = 1;
        List<Artikelstamm> allartikellist = jtm1.query("select * from ARTIKELSTAMM where selectionclient like " + "'" + selectionnumber + "'", new BeanPropertyRowMapper(Artikelstamm.class));
        return allartikellist;
    }


}

