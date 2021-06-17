package de.jgsoftware.lanserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.h2.tools.Server;


@SpringBootApplication
public class LanServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LanServerApplication.class, args);
    }

}
