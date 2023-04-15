package de.jgsoftware.lanserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
/**
 *
 * @author hoscho
 */
@SpringBootApplication
public interface iLanServerApplication
{

    static void main(String[] args)
    {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Europe/Berlin"));
        //ZonedDateTime now = ZonedDateTime.now();

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
