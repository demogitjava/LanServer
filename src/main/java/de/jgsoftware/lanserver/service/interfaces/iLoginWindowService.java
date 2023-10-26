package de.jgsoftware.lanserver.service.interfaces;

import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoLoginWindow;


/**
 *
 * @author hoscho
 */
@Service
public interface iLoginWindowService
{
    DaoLoginWindow getLoginWindow();
    void setLoginWindow(DaoLoginWindow loginWindow);

}
