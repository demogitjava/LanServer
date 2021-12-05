package de.jgsoftware.lanserver.service;


import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.Metadata;
import de.jgsoftware.lanserver.dao.DaoReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.v1.DbxUrlWithExpiration;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.GetTemporaryLinkResult;
import com.dropbox.core.v2.files.Metadata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService implements de.jgsoftware.lanserver.service.interfaces.iReportService
{

    @Autowired
    DaoReports daoReports;

    @Autowired
    DbxClientV2 dropboxClient;

    public ReportService()
    {

    }

    public void uploadFile(MultipartFile file, String filePath)
    {

        try
        {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(file.getBytes());
            Metadata uploadMetaData = dropboxClient.files().uploadBuilder(filePath).uploadAndFinish(inputStream);

            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }


    public static boolean isInternetReachable()
    {
        try {

            InetAddress address = InetAddress.getByName("dropbox.com");

            if(address == null)
            {
                return false;
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }



    public DaoReports getDaoReports() {
        return daoReports;
    }

    public void setDaoReports(DaoReports daoReports) {
        this.daoReports = daoReports;
    }
}

