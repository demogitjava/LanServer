package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/offernumber")
public class CtrReports
{

    @Autowired
    ReportService reportService;


    // pdf angebot response
    @GetMapping("/getOffer/{offernumber}")
    public String getUserById(@PathVariable("offernumber") String offernumber) throws JRException, SQLException, IOException {

        offernumber = new String();
        reportService.getDaoReports().createOffer();


        return offernumber;
    }




}
