/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.service;

import de.jgsoftware.lanserver.dao.DaoCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.jgsoftware.lanserver.dao.interfaces.iDaoCustomer;
/**
 *
 * @author hoscho
 */
@Service
public class SCustomer implements de.jgsoftware.lanserver.service.interfaces.iSCustomer
{
    @Autowired
    DaoCustomer daocustomer;



    public SCustomer()
    {

    }


    @Override
    public DaoCustomer getDaocustomer() {
        return daocustomer;
    }
    @Override
    public void setDaocustomer(DaoCustomer daocustomer) {
        this.daocustomer = daocustomer;
    }
    
    
}
