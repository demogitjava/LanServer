package de.jgsoftware.lanserver.dao;


import de.jgsoftware.lanserver.model.Desktoplayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoLoginWindow
{
    @Autowired
    @Qualifier("defaultJdbcTemplate")
    private JdbcTemplate jtm;


    /*

         Desktoplayout table
         return
         LOGIN Text for Labels

   */
    public List<Desktoplayout> getlogintextentry()
    {

        String result = new String("loginframe");

        String sql = "select * from desktoptextlayout where framename like " + "'" + result + "'";
        System.out.print(sql + "\n" + "\n");
        List<Desktoplayout> loginentry = jtm.query("select * from desktoplayout where framename like " + "'" + result + "'", new BeanPropertyRowMapper(Desktoplayout.class));
        return loginentry;
    }

    /*



      of Framename from
      Desktop
      request over Framename

   */
    public List<Desktoplayout> getFrameDesktopEntry(String framename)
    {

        String result = framename.toString();

        String sql = "select * from DESKTOPLAYOUT where framename like " + "'" + result + "'";
        System.out.print(sql + "\n" + "\n");
        List<Desktoplayout> desktopframeentytext = jtm.query("select * from DESKTOPLAYOUT where framename like " + "'" + result + "'", new BeanPropertyRowMapper(Desktoplayout.class));
        return desktopframeentytext;

    }




}
