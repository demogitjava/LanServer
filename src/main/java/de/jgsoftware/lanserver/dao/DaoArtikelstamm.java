package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.model.Artikelstamm;
import de.jgsoftware.lanserver.model.MKundenstamm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoArtikelstamm
{

    @Autowired
    JdbcTemplate jtm;


    public List<Artikelstamm> getAllArtikel()
    {

        List<Artikelstamm> allartikellist = jtm.query("select * from ARTIKELSTAMM", new BeanPropertyRowMapper(Artikelstamm.class));
        return allartikellist;
    }

}

