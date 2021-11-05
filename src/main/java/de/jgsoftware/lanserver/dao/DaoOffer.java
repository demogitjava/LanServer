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

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public class DaoOffer {

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;

    @Autowired
    MaWiDBConfig maWiDBConfig;



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
        // get id count from table
        Integer intcount = (Integer) countid.size() + 1;


        Buchungsdaten buchdat = new Buchungsdaten();


        for(int i = 0; i < buchungsdaten.size(); i++)
        {



            // beleg
            Integer idbuchdat = intcount + 200000;

            // get id from rowtable bevor save pojo
            Integer rowidforsave= 0;
            getIdfromtable(rowidforsave);

            buchdat.setId(rowidforsave);  // id
            buchdat.setKdnummer(buchungsdaten.get(i).getKdnummer()); // kdnummer
            buchdat.setKdname(buchungsdaten.get(i).getKdname()); // kdname

            buchdat.setBeleg(idbuchdat);
            buchdat.setArtikelnummer(buchungsdaten.get(i).getArtikelnummer());


            Date datum = new java.util.Date();
            //SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            //String dateString = (Date) formater.format(datum);
            buchdat.setBdatum(datum);
            try
            {

                jpaBuchungsdaten.save(buchdat);
            } catch (Exception e)
            {
                System.out.print("Fehler " +e);
            }
        }

        return buchungsdaten;
    }

    public Integer getIdfromtable(Integer rowidforsave)
    {

        List<Buchungsdaten> countid = jtm1.query("SELECT COUNT(*) FROM Buchungsdaten", new BeanPropertyRowMapper(Buchungsdaten.class));
        rowidforsave = countid.get(0).getId();
        return rowidforsave;
    }


}
