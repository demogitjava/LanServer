package de.jgsoftware.lanserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public interface iLanServerApplication
{

    public static void main(String[] args)
    {
        /*
        System.setProperty("spring.profiles.default", "dev");
        System.setProperty("spring.devtools.restart.enabled", "true");
            */
        SpringApplication.run(LanServerApplication.class, args);
    }



}
