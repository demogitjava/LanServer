package de.jgsoftware.lanserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.h2.tools.Server;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class LanServerApplication {

    public static void main(String[] args)
    {
        System.setProperty("spring.profiles.default", "dev");

        System.setProperty("spring.devtools.restart.enabled", "true");
        SpringApplication.run(LanServerApplication.class, args);
    }

}
