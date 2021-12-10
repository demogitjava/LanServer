package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.dao.interfaces.mawi.JPABuchungsdaten;
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



    // return offernumber to client
    @GetMapping("/getOffer/{offernumber}")
    public String getUserById(@PathVariable("offernumber") String offernumber) throws JRException, SQLException, IOException {

        reportService.getDaoReports().createOffer(offernumber);

        return offernumber;
    }


}