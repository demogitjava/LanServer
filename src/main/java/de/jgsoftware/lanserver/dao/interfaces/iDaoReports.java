package de.jgsoftware.lanserver.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;


/**
 *
 * @author hoscho
 */

@Repository
public interface iDaoReports
{
    JasperPrint createOffer(String offernumber) throws SQLException, JRException, IOException;
}
