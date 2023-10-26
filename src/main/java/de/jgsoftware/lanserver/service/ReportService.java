package de.jgsoftware.lanserver.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoReports;
/**
 *
 * @author hoscho
 */
@Service
public class ReportService implements de.jgsoftware.lanserver.service.interfaces.iReportService
{

    @Autowired
    DaoReports daoReports;



    public ReportService()
    {

    }






    @Override
    public DaoReports getDaoReports() {
        return daoReports;
    }
    @Override
    public void setDaoReports(DaoReports daoReports) {
        this.daoReports = daoReports;
    }
}

