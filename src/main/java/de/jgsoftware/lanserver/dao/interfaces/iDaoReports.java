package de.jgsoftware.lanserver.dao.interfaces;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.IOException;
import java.sql.SQLException;

public interface iDaoReports
{
    public JasperPrint createOffer(String offernumber) throws SQLException, JRException, IOException;
}
