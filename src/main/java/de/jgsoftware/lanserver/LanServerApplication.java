package de.jgsoftware.lanserver;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;


//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class LanServerApplication {


    private org.h2.tools.Server h2Server;


    private DriverManagerDataSource dataSource3;
    private DriverManagerDataSource dataSource1;
    private DriverManagerDataSource dataSource2;

    public LanServerApplication()
    {

        startH2Server();
    }

    // start h2 database server
    private static void startH2Server()
    {
        try
        {
            org.h2.tools.Server h2Server = Server.createTcpServer().start();
            if (h2Server.isRunning(true))
            {
                System.out.print("H2 server was started and is running." + "\n");
            } else
            {
                h2Server = Server.createTcpServer().start();
                throw new RuntimeException("Could not start H2 server." + "\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to start H2 server: " + e + "\n");
        }

    }

    // demodb
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource datasource3()
    {
        dataSource3 = new DriverManagerDataSource();
        dataSource3.setDriverClassName("org.h2.Driver");
        dataSource3.setUrl("jdbc:h2:tcp://localhost:9092/~/demodb");
        dataSource3.setUsername("admin");
        dataSource3.setPassword("jj78mvpr52k1");

        return dataSource3;
    }


    // mawi db
    public DataSource dataSource1()
    {
        dataSource1 = new DriverManagerDataSource();
        dataSource1.setDriverClassName("org.h2.Driver");
        dataSource1.setUrl("jdbc:h2:tcp://localhost:9092/~/mawi");
        dataSource1.setUsername("admin");
        dataSource1.setPassword("jj78mvpr52k1");

        return dataSource1;
    }


    public DataSource dataSource2()
    {
        dataSource2 = new DriverManagerDataSource();
        dataSource2.setDriverClassName("org.h2.Driver");
        dataSource2.setUrl("jdbc:h2:tcp://localhost:9092/~/fibu");
        dataSource2.setUsername("admin");
        dataSource2.setPassword("jj78mvpr52k1");

        return dataSource2;
    }




    @Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource)
    {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       // vendorAdapter.setDatabase(Database.H2);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("de.jgsoftware.lanserver.model");
        
        
        factory.setDataSource(datasource3());  // demodb
        factory.setDataSource(dataSource2()); // mawi
        factory.setDataSource(dataSource1()); // fibu


        factory.afterPropertiesSet();
        return factory.getObject();
    }


    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
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
