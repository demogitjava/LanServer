package de.jgsoftware.lanserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author hoscho
 */
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class LanServerApplication
{

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

    public static String st_timezones = "Europe/Berlin";

    public static void main(String[] args)
    {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of(st_timezones));
        //ZonedDateTime now = ZonedDateTime.now();

        // set up to GMT
        now.withZoneSameInstant( ZoneId.of("GMT") )
                .format( DateTimeFormatter.ISO_OFFSET_DATE_TIME );
        // 1. ZonedDateTime to TimeStamp
        Timestamp timestamp = Timestamp.valueOf(now.toLocalDateTime());

        // 2. ZonedDateTime to TimeStamp , no different
        Timestamp timestamp2 = Timestamp.from(now.toInstant());

        System.out.println(now);
        System.out.println(timestamp);
        System.out.println(timestamp2);



        SpringApplication.run(LanServerApplication.class, args);
    }



}
