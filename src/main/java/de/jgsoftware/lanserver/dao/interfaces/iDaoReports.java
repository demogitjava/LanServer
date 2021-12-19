package de.jgsoftware.lanserver.dao.interfaces;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.SQLException;
@Repository
public interface iDaoReports
{
    public JasperPrint createOffer(String offernumber) throws SQLException, JRException, IOException;
}
