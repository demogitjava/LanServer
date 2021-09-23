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
import java.sql.SQLException;


//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class LanServerApplication {


    private Server h2Server;


    public LanServerApplication()
    {

        try {
            h2Server();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    // start h2 database server
    private static void startH2Server()
    {
        try
        {
           // Server h2Server = Server.createTcpServer().start();
            Server h2Server = Server.createTcpServer("-tcpPort", "9092", "-tcpAllowOthers").start();
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
    */


    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }

    // demodb

    /*
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource datasource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        return dataSource;
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