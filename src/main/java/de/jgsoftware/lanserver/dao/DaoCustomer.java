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
        this.jtm = jtm;
    }
    
    public List<MKundenstamm> getCustomerbyname(String customername)
    {
        String beginswith = customername + "%";
        List<MKundenstamm> customerlist = jtm.query("select * from kundenstamm where kundenname like " + "'" + beginswith + "'", new BeanPropertyRowMapper(MKundenstamm.class));
        return customerlist;
    }

    public MKundenstamm createCustomer(MKundenstamm mKundenstamm)
    {

        //String saveuser = "INSERT INTO KUNDENSTAMM(kundennummer,kundenname,land,name_Anschrift1,name_Anschrift2,name_Anschrift3,name_Anschrift4,strasse,plz,ort,iban,blz,konto_nr,kreditlimit,telefon,mobil1,mobil2,sip,email,ansprechpartner,umsatz_Lfd_Jahr,umsatz_Jahr_1,umsatz_Jahr_2,timestamp,gebiet,vertreter,bankverbindung,id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        mKundenstamm.setId(3);
        return interfaceDCustomer.save(mKundenstamm);
    }
}


