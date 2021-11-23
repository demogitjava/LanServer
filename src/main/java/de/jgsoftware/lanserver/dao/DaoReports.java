package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.model.Yourcompanydata;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
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

@Repository
public class DaoReports
{

    @Autowired
    @Qualifier("defaultJdbcTemplate")
    JdbcTemplate jtm;

    @Autowired
    private ResourceLoader resourceLoader;

    JasperReport offerReport;



    // angebot erstellen
    public JasperPrint createOffer(String offernumber) throws SQLException, JRException, IOException
    {


        List<Yourcompanydata> employees = jtm.query("select * from YOURCOMPANYDATA", new BeanPropertyRowMapper(Yourcompanydata.class));




        //load file and compile it
        //File file = ResourceUtils.getFile("classpath:offerreport.jrxml");
        //File file = new ClassPathResource("offerreport.jrxml").getFile();


        //InputStream file = new ClassPathResource("offerreport.jrxml").getInputStream();
        File file = ResourceUtils.getFile("classpath:offerreport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(String.valueOf(file));
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("reportby", "Demo asdf sdfsdf");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint,  "offerreport.pdf");

        return jasperPrint;
    }




}
