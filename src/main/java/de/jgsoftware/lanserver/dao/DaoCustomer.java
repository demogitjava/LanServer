/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.dao;

import de.jgsoftware.lanserver.dao.interfaces.JPACustomer;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import de.jgsoftware.lanserver.model.MKundenstamm;

import java.util.*;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import de.jgsoftware.lanserver.dao.interfaces.DCustomer;

@Repository
public class DaoCustomer 
{


    @Autowired
    JdbcTemplate jtm;

    @Autowired
    DCustomer interfaceDCustomer;

    @Autowired
    JPACustomer restjpacustomer;

    private MKundenstamm kdstamm;
    
    public DaoCustomer()
    {


    }
    
   
    public List<MKundenstamm> getCustomerbyname(String customername)
    {
        String beginswith = customername + "%";
        List<MKundenstamm> customerlist = jtm.query("select * from kundenstamm where kundenname like " + "'" + beginswith + "'", new BeanPropertyRowMapper(MKundenstamm.class));
        return customerlist;
    }
    
    

    public MKundenstamm UpdateCustomer(MKundenstamm dtokundenstamm)
    {

        return interfaceDCustomer.save(dtokundenstamm);
    }

    

    public MKundenstamm save(MKundenstamm mKundenstamm)
    {
        Long id = (Long) interfaceDCustomer.count();
        mKundenstamm.setId(id+1);

        return interfaceDCustomer.save(mKundenstamm);
    }

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

   
}


