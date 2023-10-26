package de.jgsoftware.lanserver.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.dao.interfaces.iDaoLoginWindow;
import main.java.de.jgsoftware.lanserver.model.Desktoplayout;

/**
 *
 * @author hoscho
 */

@Repository
public class DaoLoginWindow implements iDaoLoginWindow
{
    @Autowired
    @Qualifier("defaultJdbcTemplate")
    private JdbcTemplate jtm;


    /*

         Desktoplayout table
         return
         LOGIN Text for Labels

   */
    @Override
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
    @Override
    public List<Desktoplayout> getFrameDesktopEntry(String framename)
    {

        String result = framename.toString();

        String sql = "select * from DESKTOPLAYOUT where framename like " + "'" + result + "'";
        System.out.print(sql + "\n" + "\n");
        List<Desktoplayout> desktopframeentytext = jtm.query("select * from DESKTOPLAYOUT where framename like " + "'" + result + "'", new BeanPropertyRowMapper(Desktoplayout.class));
        return desktopframeentytext;

    }




}
