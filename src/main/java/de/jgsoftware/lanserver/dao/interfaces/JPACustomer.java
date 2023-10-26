package de.jgsoftware.lanserver.dao.interfaces;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.MKundenstamm;



/**
 *
 * @author hoscho
 */
@Repository
public interface JPACustomer extends JpaRepository<MKundenstamm, Long>, JpaSpecificationExecutor<MKundenstamm> {

}
