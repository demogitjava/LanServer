package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.config.MaWiDBConfig;
import de.jgsoftware.lanserver.dao.interfaces.CrudOffer;
import de.jgsoftware.lanserver.dao.interfaces.DCustomer;
import de.jgsoftware.lanserver.dao.interfaces.JPACustomer;
import de.jgsoftware.lanserver.dao.interfaces.JPAOffer;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class DaoOffer
{

    public DaoOffer()
    {


    }

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;

    @Autowired
    de.jgsoftware.lanserver.config.MaWiDBConfig maWiDBConfig;

    @Autowired
    JPAOffer jpaOffer;

    @Autowired
    CrudOffer crudOffer;

    public List<Buchungsdaten> savenewOffer(List<Buchungsdaten> buchungsdaten)
    {


        List<Buchungsdaten> countid = jtm1.query("SELECT COUNT(*) FROM Buchungsdaten where BELEG BETWEEN 200000 and 299999", new BeanPropertyRowMapper(Buchungsdaten.class));
        Integer intcount = (Integer) countid.get(0).getId();


        Buchungsdaten buchdat = new Buchungsdaten();

        for(int i = 0; i < buchungsdaten.size(); i++)
        {

            Integer id = buchungsdaten.get(i).getId() + 1 + 200000;



            buchdat.setId(id);
            buchdat.setArtikelnummer(buchungsdaten.get(i).getArtikelnummer());
            try
            {
                Buchungsdaten buchungsdaten1 = new Buchungsdaten();

                crudOffer.count();
                crudOffer.save(buchdat);
            } catch (Exception e)
            {
                System.out.print("Fehler " +e);
            }
        }

        return buchungsdaten;
    }



}
