/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.dao;

import de.jgsoftware.lanserver.model.Desktoplayout;
import org.springframework.stereotype.Repository;
import de.jgsoftware.lanserver.model.MKundenstamm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import de.jgsoftware.lanserver.model.MKundenstamm;

@Repository
public class DaoCustomer 
{
     @Autowired
    private JdbcTemplate jtm;

    private MKundenstamm kdstamm;
    
    public List<MKundenstamm> getCustomerbyname(String customername)
    {
        String beginswith = customername + "%";
        List<MKundenstamm> customerlist = jtm.query("select * from kundenstamm where kundenname like " + "'" + beginswith + "'", new BeanPropertyRowMapper(MKundenstamm.class));
        return customerlist;
    }

    public MKundenstamm createCustomer(MKundenstamm mKundenstamm)
    {

        String saveuser = "INSERT INTO KUNDENSTAMM(id,fname,lname,email) values(?,?,?,?)";
        jtm.update(saveuser, kdstamm);

        return mKundenstamm;
    }
}
