package de.jgsoftware.lanserver;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.net.ssl.HttpsURLConnection;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.File;
import java.sql.SQLException;


//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class LanServerApplication {



    //private org.h2.tools.Server tcpServer;


    public LanServerApplication()
    {

    }



    @Bean
    @ConfigurationProperties(prefix="spring.datasource1")
    public DataSource datasource1()
    {
        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        return dataSource1;
    }






    // single db connect  demodb / spring.datasource
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource datasource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        return dataSource;
    }








    // demodb

    /*
    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource)
    {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        // vendorAdapter.setDatabase(Database.H2);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("de.jgsoftware.lanserver.model");
        factory.setDataSource(dataSource);
        factory.afterPropertiesSet();
        return factory.getObject();
    }


     */



    static {
        //for localhost testing only
        HttpsURLConnection.setDefaultHostnameVerifier(
                (hostname, sslSession) -> hostname.equals("localhost"));
    }


    public static void main(String[] args)
    {
        /*
        System.setProperty("spring.profiles.default", "dev");
        System.setProperty("spring.devtools.restart.enabled", "true");
            */
        SpringApplication.run(LanServerApplication.class, args);
    }

}