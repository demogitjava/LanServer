package de.jgsoftware.lanserver.dao.interfaces;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author hoscho
 */

@Repository
public interface iDaoReports
{
    JasperPrint createOffer(String offernumber) throws SQLException, JRException, IOException;
}
