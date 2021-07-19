/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.service;

import de.jgsoftware.lanserver.dao.DaoCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hoscho
 */
@Service
public class SCustomer 
{
    @Autowired
    DaoCustomer daocustomer;

    public DaoCustomer getDaocustomer() {
        return daocustomer;
    }

    public void setDaocustomer(DaoCustomer daocustomer) {
        this.daocustomer = daocustomer;
    }
    
    
}
