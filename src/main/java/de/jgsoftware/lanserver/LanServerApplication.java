package de.jgsoftware.lanserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@SpringBootApplication
public class LanServerApplication {

    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                (hostname, sslSession) -> hostname.equals("localhost"));
    }

    public static void main(String[] args)
    {
        System.setProperty("spring.profiles.default", "dev");

        System.setProperty("spring.devtools.restart.enabled", "true");



        SpringApplication.run(LanServerApplication.class, args);
    }




}
