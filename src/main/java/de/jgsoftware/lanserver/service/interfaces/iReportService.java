package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoReports;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


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
