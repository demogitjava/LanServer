package de.jgsoftware.lanserver.dao.interfaces;


import de.jgsoftware.lanserver.model.MKundenstamm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



/**
 *
 * @author hoscho
 */
@Repository
public interface JPACustomer extends JpaRepository<MKundenstamm, Long>, JpaSpecificationExecutor<MKundenstamm> {

}
