package de.jgsoftware.lanserver.controller.interfaces;


import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author hoscho
 */
@RequestMapping("/report")
public interface i_CtrReports
{

    @GetMapping("/getOffer/{offernumber}")
    String getUserById(@PathVariable("offernumber") String offernumber) throws JRException, SQLException, IOException;
}
