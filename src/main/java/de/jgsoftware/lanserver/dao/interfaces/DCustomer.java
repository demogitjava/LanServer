/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.MKundenstamm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hoscho
 */
public interface DCustomer extends JpaRepository<MKundenstamm, Integer>
{
    
  
}
