package de.jgsoftware.lanserver.service.interfaces;

import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoReports;


/**
 *
 * @author hoscho
 */
@Service
public interface iReportService
{
    DaoReports getDaoReports();
    void setDaoReports(DaoReports daoReports);

}
