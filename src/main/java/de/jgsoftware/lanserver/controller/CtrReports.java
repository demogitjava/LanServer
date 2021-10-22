package de.jgsoftware.lanserver.controller;


import de.jgsoftware.lanserver.model.MKundenstamm;
import de.jgsoftware.lanserver.model.mawi.Artikelstamm;
import de.jgsoftware.lanserver.service.ReportService;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
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
    public ResponseEntity getUserById(@PathVariable("offernumber") String offernumber) throws JRException, SQLException, IOException {

        offernumber = new String();
        reportService.getDaoReports().createOffer();


        return (ResponseEntity) ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_PDF);
    }




}
