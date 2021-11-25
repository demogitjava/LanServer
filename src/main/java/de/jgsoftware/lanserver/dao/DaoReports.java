package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.model.Yourcompanydata;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.core.io.ClassPathResource;

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

@Repository
public class DaoReports
{

    @Autowired
    @Qualifier("defaultJdbcTemplate")
    JdbcTemplate jtm;



    JasperReport offerReport;

    JasperPrint jasperPrint;

    ClassPathResource res;

    // angebot erstellen
    public JasperPrint createOffer(String offernumber) throws SQLException, JRException, IOException
    {


        List<Yourcompanydata> employees = jtm.query("select * from YOURCOMPANYDATA", new BeanPropertyRowMapper(Yourcompanydata.class));

        //File file = ResourceUtils.getFile("classpath:offerreport.jrxml").getAbsoluteFile();
        Resource resource = new ClassPathResource("offerreport.jrxml");

        InputStream input = resource.getInputStream();

        File file = resource.getFile();
        JasperReport jasperReport = JasperCompileManager.compileReport(String.valueOf(file));


        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("reportby", "Demo asdf sdfsdf");

        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,  "offerreport.pdf");

        return jasperPrint;
    }




}
