package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.model.Yourcompanydata;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.io.*;
import java.sql.SQLException;
import java.util.*;

import org.springframework.core.io.ResourceLoader;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;

@Repository
public class DaoReports
{

    @Autowired
    @Qualifier("defaultJdbcTemplate")
    JdbcTemplate jtm;

    @Autowired
    private ResourceLoader resourceLoader;

    JasperReport offerReport;
    HttpServletResponse response;


    // angebot erstellen
    public JasperPrint createOffer() throws SQLException, JRException, IOException
    {


        List<Yourcompanydata> employees = jtm.query("select * from YOURCOMPANYDATA", new BeanPropertyRowMapper(Yourcompanydata.class));
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:offerreport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("reportby", "Demo");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,  "offerreport.pdf");

        return jasperPrint;
    }


    public Buchungsdaten saveoffertodb(Buchungsdaten buchungsdaten)
    {


        return buchungsdaten;
    }

}
