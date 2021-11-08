package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.model.MKundenstamm;
import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoArtikelstamm
{



    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;


    public DaoArtikelstamm()
    {


    }



    public List<Artikelstamm> getAllArtikel()
    {

        List<Artikelstamm> allartikellist = jtm1.query("select * from ARTIKELSTAMM", new BeanPropertyRowMapper(Artikelstamm.class));
        return allartikellist;
    }

    public List<Artikelstamm> getArtikelselectionclient(String bezeichnung)
    {
        String beginswith = bezeichnung + "%";
        List<Artikelstamm> arikelclientselection = jtm1.query("select * from artikelstamm where artikelbezeichnung like " + "'" + beginswith + "'", new BeanPropertyRowMapper(Artikelstamm.class));
        return arikelclientselection;
    }

    public List<Artikelstamm> getSelectedAllArtikel()
    {
        Integer selectionnumber = 1;
        List<Artikelstamm> allartikellist = jtm1.query("select * from ARTIKELSTAMM where selectionclient like " + "'" + selectionnumber + "'", new BeanPropertyRowMapper(Artikelstamm.class));
        return allartikellist;
    }


}

