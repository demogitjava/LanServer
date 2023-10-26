package de.jgsoftware.lanserver.config;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author hoscho
 */

@Configuration
public class FileConfiguration implements WebMvcConfigurer
{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("classpath:/resources/**")
               .addResourceLocations("classpath:/resources/**");
    }


    /*
                create a pdf folder
                under root default
                to save pdf files to disk

                like offer or other reports
     */
    public static void checkFolders()
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

    /*
            add module folder for jars
            to inject at runtime

     */
    public static void addModulejarFolder()
    {
        String userhome = "user.home";
        String path = System.getProperty(userhome);

        File pdffolder = new File(path + "/modules");
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


    public void loaddropboxclient()
    {


    }





}
