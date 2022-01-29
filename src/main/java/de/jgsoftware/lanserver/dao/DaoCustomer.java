/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.dao;

import de.jgsoftware.lanserver.dao.interfaces.JPACustomer;
import de.jgsoftware.lanserver.dao.interfaces.iDaoCustomer;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import de.jgsoftware.lanserver.model.MKundenstamm;

import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import de.jgsoftware.lanserver.dao.interfaces.DCustomer;

@Repository
public class DaoCustomer implements iDaoCustomer
{


    @Autowired
    @Qualifier("defaultJdbcTemplate")
    JdbcTemplate jtm;

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;

    @Autowired
    DCustomer interfaceDCustomer;

    @Autowired
    JPACustomer restjpacustomer;

    private MKundenstamm kdstamm;
    
    public DaoCustomer()
    {


    }
    
    @Override
    public List<MKundenstamm> getCustomerbyname(String customername)
    {
        String beginswith = customername + "%";
        List<MKundenstamm> customerlist = jtm.query("select * from kundenstamm where kundenname like " + "'" + beginswith + "'", new BeanPropertyRowMapper(MKundenstamm.class));
        return customerlist;
    }


    @Override
    public MKundenstamm UpdateCustomer(MKundenstamm dtokundenstamm)
    {

        return interfaceDCustomer.save(dtokundenstamm);
    }


    @Override
    public MKundenstamm save(MKundenstamm mKundenstamm)
    {
        Long id = (Long) interfaceDCustomer.count();
        mKundenstamm.setId(id+1);

        return interfaceDCustomer.save(mKundenstamm);
    }
    @Override
    public List createnewCustomer()
    {

        Long kundennummer = (Long) interfaceDCustomer.count();
        Long kdnummernkreis = kundennummer + 10102000 + 1;

        Long id = (Long) interfaceDCustomer.count() +1;


        MKundenstamm mkdstamm = new MKundenstamm();
        mkdstamm.setId(id);
        mkdstamm.setKundennummer(kdnummernkreis);

        List<MKundenstamm> newcustomerlist = new ArrayList<>();
        newcustomerlist.add(mkdstamm);


        return newcustomerlist;
    }

    @Override
    public MKundenstamm deleteCusomter(MKundenstamm dtokundenstamm)
    {
        restjpacustomer.deleteById(dtokundenstamm.getId());
        return dtokundenstamm;
    }

    @Override
    public List<Buchungsdaten> getDocumentsforcustomer(String customernumber)
    {



        Calendar calendar = new GregorianCalendar();


        int intyear = calendar.get(Calendar.YEAR);



        // quarter period
        int intmonth = calendar.get(Calendar.MONTH);
        switch(intmonth)
        {

            case 1:
                intmonth = 0;
                break;

            case 2:
                intmonth = 0;
                break;

            case 3:
                intmonth = 0;
                break;

            case 4:
                intmonth = 3;
                break;

            case 5:
                intmonth = 3;
                break;

            case 6:
                intmonth = 3;
                break;

            case 7:
                intmonth = 6;
                break;

            case 8:
                intmonth = 6;
                break;

            case 9:
                intmonth = 6;
                break;

            case 10:
                intmonth = 9;
                break;

            case 11:
                intmonth = 9;
                break;

            case 12:
                intmonth = 9;
                break;

            default:
                break;


        }


        // select id, kdnummer, beleg, wg, vk, bdatum, artikelnummer, belegart, buchungskz, menge, month(bdatum) as month, year(bdatum) as year from buchungsdaten where year(bdatum) = 2021 and month(bdatum) > 9
        String sql = "select id, kdnummer, beleg, wg, vk, bdatum, artikelnummer, belegart, buchungskz, menge, month(bdatum) as month, year(bdatum) as year from buchungsdaten where year(bdatum) = "
                + "" + intyear + ""
                + " and month(bdatum) > " + intmonth;


        List<Buchungsdaten> documentlist = jtm1.query(sql, new BeanPropertyRowMapper(Buchungsdaten.class));
        return documentlist;
    }
   
}


