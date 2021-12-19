package de.jgsoftware.lanserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class LanServerApplication
{


    private org.h2.tools.Server h2Server;

    public LanServerApplication()
    {


    }



    /*
    // demodb
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource datasource()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        return dataSource;
    }


    @Bean
    @Primary
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
