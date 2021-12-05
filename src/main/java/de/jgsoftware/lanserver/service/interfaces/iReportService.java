package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoReports;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface iReportService
{
    DaoReports getDaoReports();
    public void setDaoReports(DaoReports daoReports);

}
