package de.jgsoftware.lanserver;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.h2.tools.Server;
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
        try {
            startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // start h2 database server
    public void startServer() throws Exception {
        new Thread(() -> {
            try {
                Server server = Server.createTcpServer().start();
               // tcpServer = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092").start();
               
                //tcpServer.run();

                System.out.print("Tcp H2 Server is started");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();


    }





    // demodb


    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource datasource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        return dataSource;
    }


    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource1")
    public DataSource datasource1()
    {
        DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
        return dataSource1;
    }

    // demodb
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