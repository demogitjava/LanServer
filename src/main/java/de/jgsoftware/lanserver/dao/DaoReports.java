package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.model.MKundenstamm;
import de.jgsoftware.lanserver.model.Reports;

import de.jgsoftware.lanserver.model.interfaces.iMReports;
import de.jgsoftware.lanserver.model.interfaces.iMKundenstamm;
import de.jgsoftware.lanserver.model.interfaces.iMYourcompanydata;
import de.jgsoftware.lanserver.model.interfaces.mawi.iMBuchungsdaten;

import de.jgsoftware.lanserver.model.Yourcompanydata;
import de.jgsoftware.lanserver.model.mawi.Buchungsdaten;
import de.jgsoftware.lanserver.service.ReportService;
import de.jgsoftware.lanserver.service.interfaces.iReportService;
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
import org.springframework.web.multipart.MultipartFile;

@Repository
public class DaoReports
{

    @Autowired
    @Qualifier("defaultJdbcTemplate")
    JdbcTemplate jtm;

    @Autowired
    @Qualifier("mawiJdbcTemplate")
    JdbcTemplate jtm1;

    @Autowired
    iReportService reportService;

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

        List<iMYourcompanydata> employees = jtm.query("select * from YOURCOMPANYDATA", new BeanPropertyRowMapper(Yourcompanydata.class));

        //File file = ResourceUtils.getFile("classpath:offerreport.jrxml").getAbsoluteFile();
        /*
        Resource resource = new ClassPathResource("offerreport.jrxml");

        InputStream input = resource.getInputStream();

        File file = resource.getFile();

        /*
                    load offerdata from
                    table buchungsdaten on mawi db

                    SELECT DISTINCT *
                        FROM buchungsdaten
                            JOIN artikelstamm ON buchungsdaten.artikelnummer = artikelstamm.artikelnummer
                        where buchungsdaten.beleg like '200000'

         */

        String offerreceipt = offernumber + "%";
        List<iMBuchungsdaten> bookingreceipt = jtm1.query("SELECT DISTINCT * FROM buchungsdaten JOIN artikelstamm ON buchungsdaten.artikelnummer = artikelstamm.artikelnummer where buchungsdaten.beleg like" + "'" + offerreceipt + "'", new BeanPropertyRowMapper(Buchungsdaten.class));

        /*
                offerdata form table buchungsdaten

                with artnumber and arttyper and offer number
                to offer details
         */
        List buchungsdtwithartst = jtm1.queryForList("SELECT DISTINCT * FROM buchungsdaten JOIN artikelstamm ON buchungsdaten.artikelnummer = artikelstamm.artikelnummer where buchungsdaten.beleg like" + "'" + offerreceipt + "'");


        /*
                   load customer master data
                   db is demodb
         */
        Long stcustomernumber = (Long) bookingreceipt.get(0).getKdnummer();
        List<iMKundenstamm> lscustomermasterdata = jtm.query("select * from KUNDENSTAMM where KUNDENNUMMER like " + "'" + stcustomernumber + "'", new BeanPropertyRowMapper(MKundenstamm.class));


        /*

                load report form db
                db is demodb

         */
        String customerepot = new String("offerreport");
        List<iMReports> lsoffereport = jtm.query("select * from reports where reportname like " + "'" + customerepot + "'", new BeanPropertyRowMapper(Reports.class));

        byte[] offerreporttext = lsoffereport.get(0).getReportdata();

        try (FileOutputStream fos = new FileOutputStream("offerreport.jrxml"))
        {

            fos.write(offerreporttext);
        }
        JasperReport jasperReport = JasperCompileManager.compileReport("offerreport.jrxml");

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

        Map<String, Object> parameters = new HashMap<>();
        //parameters.put("reportby", "Demo asdf sdfsdf");

        /*
                add customer data as parameter
                for letterhead in report
         */




        /*
                    add customer data to letterhead of report
         */
        parameters.put("firmenname", lscustomermasterdata.get(0).getKundenname()); // String
        parameters.put("strassecustomer", lscustomermasterdata.get(0).getStrasse()); // String
        parameters.put("plzcustomer", String.valueOf(lscustomermasterdata.get(0).getPlz())); // Integer cast to stirng
        parameters.put("ortcustomer", lscustomermasterdata.get(0).getOrt()); // String

        parameters.put("offernumber", offernumber);


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