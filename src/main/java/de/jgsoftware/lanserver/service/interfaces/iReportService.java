package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoReports;
import org.springframework.stereotype.Service;

@Service
public interface iReportService
{
    DaoReports getDaoReports();
    public void setDaoReports(DaoReports daoReports);
}
