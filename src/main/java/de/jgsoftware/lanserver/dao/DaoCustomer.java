/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.dao;

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


    final
    JdbcTemplate jtm;

    final
    DCustomer interfaceDCustomer;

    private MKundenstamm kdstamm;
    
    public DaoCustomer(DCustomer interfaceDCustomer, JdbcTemplate jtm)
    {


        this.interfaceDCustomer = interfaceDCustomer;
        this.jtm = jtm;
    }
    
   
    public List<MKundenstamm> getCustomerbyname(String customername)
    {
        String beginswith = customername + "%";
        List<MKundenstamm> customerlist = jtm.query("select * from kundenstamm where kundenname like " + "'" + beginswith + "'", new BeanPropertyRowMapper(MKundenstamm.class));
        return customerlist;
    }
    
    
    // save new customer
    /*
    public MKundenstamm saveCustomer(MKundenstamm mKundenstamm)
    {       
       
        int id = (int) interfaceDCustomer.count();
        mKundenstamm.setId(id+1);

        return interfaceDCustomer.save(mKundenstamm);
    }
    */
    

    public MKundenstamm saveOrUpdate(MKundenstamm mKundenstamm)
    {
        int id = (int) interfaceDCustomer.count();
        mKundenstamm.setId(id+1);



        return interfaceDCustomer.save(mKundenstamm);
    }

   
}


