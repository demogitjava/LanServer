/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.MKundenstamm;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import de.jgsoftware.lanserver.model.MKundenstamm;

import javax.persistence.Id;

/**
 *
 * @author hoscho
 */
@Repository
public interface DCustomer extends CrudRepository<MKundenstamm, Integer>
{

  
}
