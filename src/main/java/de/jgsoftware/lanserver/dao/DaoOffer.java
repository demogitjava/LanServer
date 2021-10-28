package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.config.MaWiDBConfig;
import de.jgsoftware.lanserver.dao.interfaces.mawi.CrudBuchungsdaten;
import de.jgsoftware.lanserver.dao.interfaces.mawi.JPABuchungsdaten;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class DaoOffer {

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;


    @Autowired
    JPABuchungsdaten jpaBuchungsdaten;

    @Autowired
    CrudBuchungsdaten crudBuchungsdaten;

    public DaoOffer()
    {

    }



    public List<Buchungsdaten> savenewOffer(List<Buchungsdaten> buchungsdaten)
    {


        List<Buchungsdaten> countid = jtm1.query("SELECT COUNT(*) FROM Buchungsdaten where BELEG BETWEEN 200000 and 299999", new BeanPropertyRowMapper(Buchungsdaten.class));
        Integer intcount = (Integer) countid.get(0).getId();


        Buchungsdaten buchdat = new Buchungsdaten();

        for(int i = 0; i < buchungsdaten.size(); i++)
        {

            Integer idbuchdat = buchungsdaten.get(i).getId() + 1 + 200000;



            buchdat.setId(idbuchdat);
            buchdat.setArtikelnummer(buchungsdaten.get(i).getArtikelnummer());
            try
            {
                Buchungsdaten buchungsdaten1 = new Buchungsdaten();

                jpaBuchungsdaten.count();
                jpaBuchungsdaten.save(buchungsdaten1);
            } catch (Exception e)
            {
                System.out.print("Fehler " +e);
            }
        }

        return buchungsdaten;
    }


}
