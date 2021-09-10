/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.dao;

import de.jgsoftware.lanserver.model.Desktoplayout;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import de.jgsoftware.lanserver.model.MKundenstamm;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import de.jgsoftware.lanserver.model.MKundenstamm;
import org.springframework.data.jpa.repository.JpaRepository;
import de.jgsoftware.lanserver.dao.interfaces.DCustomer;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Repository
public class DaoCustomer 
{
    @Autowired
    private JdbcTemplate jtm;

    @Autowired
    private DCustomer interfaceDCustomer;
    
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
   
    public MKundenstamm saveCustomer(MKundenstamm mKundenstamm)
    {       
       
        int id = (int) interfaceDCustomer.count();
        mKundenstamm.setId(id);
        
        return interfaceDCustomer.save(mKundenstamm); 
    }

   
}


