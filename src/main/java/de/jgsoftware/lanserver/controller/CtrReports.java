package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.service.interfaces.iReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import de.jgsoftware.lanserver.controller.interfaces.i_CtrReports;

import java.io.IOException;
import java.sql.SQLException;

@Controller

public class CtrReports implements i_CtrReports
{

    @Autowired
    iReportService reportService;



    // return offernumber to client
    @Override
    public String getUserById(@PathVariable("offernumber") String offernumber) throws JRException, SQLException, IOException {

        reportService.getDaoReports().createOffer(offernumber);

        return offernumber;
    }


}