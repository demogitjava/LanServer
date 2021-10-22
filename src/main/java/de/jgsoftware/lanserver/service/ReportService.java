package de.jgsoftware.lanserver.service;


import de.jgsoftware.lanserver.dao.DaoReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService
{

    @Autowired
    DaoReports daoReports;

    public DaoReports getDaoReports() {
        return daoReports;
    }

    public void setDaoReports(DaoReports daoReports) {
        this.daoReports = daoReports;
    }
}