package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.model.MKundenstamm;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import de.jgsoftware.lanserver.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

    @PostMapping("/savenewoffer")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Buchungsdaten> createnewcustomer(@RequestBody List<Buchungsdaten> buchungsdaten)
    {

        //reportService.getDaoReports().saveoffertodb(buchungsdaten);
        return buchungsdaten;
    }
}
