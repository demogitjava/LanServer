/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.dao.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.MKundenstamm;

/**
 *
 * @author hoscho
 */
@Repository
public interface DCustomer extends CrudRepository<MKundenstamm, Integer>
{

  
}
