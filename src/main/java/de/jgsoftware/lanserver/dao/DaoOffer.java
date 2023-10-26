package de.jgsoftware.lanserver.dao;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.dao.interfaces.iDaoOffer;
import main.java.de.jgsoftware.lanserver.dao.interfaces.mawi.CrudBuchungsdaten;
import main.java.de.jgsoftware.lanserver.dao.interfaces.mawi.JPABuchungsdaten;
import main.java.de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import main.java.de.jgsoftware.lanserver.model.mawi.Buchungsdaten;

/**
 *
 * @author hoscho
 */

@Repository
public class DaoOffer implements iDaoOffer {

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;


    @Autowired
    JPABuchungsdaten jpaBuchungsdaten;

    @Autowired
    CrudBuchungsdaten crudBuchungsdaten;


    public List<Buchungsdaten> offercachelist;

    public List<Buchungsdaten> buchungsdaten;

    public DaoOffer()
    {


    }


    @Override
    public List<Buchungsdaten> savenewOffer(List<Buchungsdaten> buchungsdaten)
    {


        // int countid = jtm1.queryforObject("SELECT COUNT(DISTINCT BELEG) FROM Buchungsdaten where BELEG BETWEEN 200000 and 299999", new Object[] { BELEG }, Integer.class);

        int countid = this.jtm1.queryForObject("SELECT COUNT(DISTINCT BELEG) FROM Buchungsdaten where BELEG BETWEEN 200000 and 299999", Integer.class);

        if(countid == 0)
        {
            int coutid = 200000;
        }

        // get id count from table
        Integer intcount = countid + 200000;



        for(int i = 0; i < buchungsdaten.size(); i++)
        {

            Buchungsdaten buchdat = new Buchungsdaten();



            // get id from rowtable bevor save pojo
            Integer rowidforsave= 0;
            getIdfromtable(rowidforsave);

            buchdat.setId(rowidforsave);  // id
            buchdat.setKdnummer(buchungsdaten.get(i).getKdnummer()); // kdnummer
            buchdat.setKdname(buchungsdaten.get(i).getKdname()); // kdname

            buchdat.setBeleg(intcount);
            buchdat.setArtikelnummer(buchungsdaten.get(i).getArtikelnummer());


            Date datum = new java.util.Date();
            //SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            //String dateString = (Date) formater.format(datum);
            buchdat.setBdatum(datum);

            buchdat.setBuchungskz(5); // set to offer

            Artikelstamm artikelstamm = new Artikelstamm();

            Long artikelnummer = buchdat.getArtikelnummer();
            List<Artikelstamm> artlist = getartikelkenzeichen(artikelnummer);

            buchdat.setWg(artlist.get(0).getWg());
            buchdat.setVk(artlist.get(0).getVk());

            buchdat.setBelegart(5);
            // einbuchung angebot
            // 2 -- Angebot
            // 2 -- Einbuchung
            buchdat.setBuchungskz(2);

            Integer menge = buchdat.getMenge();
            if(menge == 0)
            {
                int bmenge = 1;
                buchdat.setMenge(bmenge);
            }
            try
            {
                jpaBuchungsdaten.save(buchdat);

                buchungsdaten.get(i).setBeleg(intcount);

            } catch (Exception e)
            {
                System.out.print("Fehler " +e);
            }

        }

        return buchungsdaten;
    }

    @Override
    public Integer getIdfromtable(Integer rowidforsave)
    {

        List<Buchungsdaten> countid = jtm1.query("SELECT COUNT(*) FROM Buchungsdaten", new BeanPropertyRowMapper(Buchungsdaten.class));
        rowidforsave = countid.get(0).getId();
        return rowidforsave;
    }

    @Override
    public List<Artikelstamm> getartikelkenzeichen(Long artikelnummer)
    {
        String beginswith = artikelnummer + "%";
        List<Artikelstamm> arikellist = jtm1.query("select * from artikelstamm where ARTIKELNUMMER like " + "'" + artikelnummer + "'", new BeanPropertyRowMapper(Artikelstamm.class));
        return arikellist;
    }

    @Override
    public List<Buchungsdaten> additemstooffercache(Buchungsdaten buchdat)
    {

        offercachelist.add(buchdat);
        return offercachelist;
    }


    @Override
    public List<Buchungsdaten> getOffercachelist() {
        return offercachelist;
    }
    @Override
    public void setOffercachelist(List<Buchungsdaten> offercachelist) {
        this.offercachelist = offercachelist;
    }
}