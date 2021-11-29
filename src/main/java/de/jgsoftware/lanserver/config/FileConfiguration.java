package de.jgsoftware.lanserver.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class FileConfiguration implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("classpath:/resources/**")
               .addResourceLocations("classpath:/resources/**");
    }


    public void checkFolders()
    {

        String userhome = "user.home";
        String path = System.getProperty(userhome);

        File pdffolder = new File(path + "/pdf");
        if(pdffolder.exists())
        {
            System.out.print("pdf tempfolder exist" + "\n");
        }
        else
        {
            Path pdfpath = Paths.get(String.valueOf(pdffolder));
            try {
                Files.createDirectory(pdfpath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
