package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.model.MKundenstamm;
import de.jgsoftware.lanserver.model.Reports;
import de.jgsoftware.lanserver.model.Yourcompanydata;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Repository
public class DaoReports
{

    @Autowired
    @Qualifier("defaultJdbcTemplate")
    JdbcTemplate jtm;

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;

    JasperReport offerReport;

    JasperPrint jasperPrint;

    public DaoReports()
    {

    }


    // angebot erstellen
    public JasperPrint createOffer(String offernumber) throws SQLException, JRException, IOException
    {

        /*
            check that /root/pdf folder exist
         */
        de.jgsoftware.lanserver.config.FileConfiguration.checkFolders();



        List<Yourcompanydata> employees = jtm.query("select * from YOURCOMPANYDATA", new BeanPropertyRowMapper(Yourcompanydata.class));



        //File file = ResourceUtils.getFile("classpath:offerreport.jrxml").getAbsoluteFile();
        /*
        Resource resource = new ClassPathResource("offerreport.jrxml");

        InputStream input = resource.getInputStream();

        File file = resource.getFile();

        */

        /*
                    load offerdata from
                    table buchungsdaten on mawi db
         */
        String offerreceipt = offernumber + "%";
        List<Buchungsdaten> bookingreceipt = jtm1.query("select * from BUCHUNGSDATEN where BELEG like " + "'" + offerreceipt + "'", new BeanPropertyRowMapper(Buchungsdaten.class));


        /*
                   load customer master data
                   db is demodb
         */
        Long stcustomernumber = (Long) bookingreceipt.get(0).getKdnummer();
        List<MKundenstamm> lscustomermasterdata = jtm.query("select * from KUNDENSTAMM where KUNDENNUMMER like " + "'" + stcustomernumber + "'", new BeanPropertyRowMapper(MKundenstamm.class));


        /*

                load report form db
                db is demodb

         */
        String customerepot = new String("offerreport");
        List<Reports> lsoffereport = jtm.query("select * from reports where reportname like " + "'" + customerepot + "'", new BeanPropertyRowMapper(Reports.class));

        byte[] offerreporttext = lsoffereport.get(0).getReportdata();

        try (FileOutputStream fos = new FileOutputStream("offerreport.jrxml"))
        {

            fos.write(offerreporttext);
        }
        JasperReport jasperReport = JasperCompileManager.compileReport("offerreport.jrxml");


        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("reportby", "Demo asdf sdfsdf");

        jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);



        String userhome = "user.home";
        String path = System.getProperty(userhome);


        String pdfkdoffernumber = String.valueOf(bookingreceipt.get(0).getKdnummer());
        String pdfoffernumber = String.valueOf(bookingreceipt.get(0).getBeleg());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateformate = dateFormat.format(new Date());
        String endpdf = ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,  path + "/pdf/" + dateformate  + "_" + pdfkdoffernumber + "_" + pdfoffernumber + endpdf);

        return jasperPrint;
    }

}
