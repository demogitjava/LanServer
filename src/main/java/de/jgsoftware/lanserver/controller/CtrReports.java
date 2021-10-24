package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.dao.interfaces.JPAOffer;
import de.jgsoftware.lanserver.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/report")
public class CtrReports
{

    @Autowired
    ReportService reportService;

    @Autowired
    JPAOffer offerReport;

    // pdf angebot response
    @GetMapping("/getOffer/{offernumber}")
    public String getUserById(@PathVariable("offernumber") String offernumber) throws JRException, SQLException, IOException {

        offernumber = new String();
        reportService.getDaoReports().createOffer();


        return offernumber;
    }



}
