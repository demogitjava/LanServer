/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.dao;

import de.jgsoftware.lanserver.dao.interfaces.JPACustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import de.jgsoftware.lanserver.model.MKundenstamm;
import java.util.List;

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
        int id = (int) interfaceDCustomer.count();
        mKundenstamm.setId(id+1);



        return interfaceDCustomer.save(mKundenstamm);
    }

   
}


