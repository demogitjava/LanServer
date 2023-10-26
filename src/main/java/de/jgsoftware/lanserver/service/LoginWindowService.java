package de.jgsoftware.lanserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.de.jgsoftware.lanserver.dao.DaoLoginWindow;

/**
 *
 * @author hoscho
 */
@Service
public class LoginWindowService implements de.jgsoftware.lanserver.service.interfaces.iLoginWindowService
{


    @Autowired
    DaoLoginWindow loginWindow;

    public LoginWindowService(DaoLoginWindow loginWindow)
    {

    }
    @Override
    public DaoLoginWindow getLoginWindow() {
        return loginWindow;
    }
    @Override
    public void setLoginWindow(DaoLoginWindow loginWindow) {
        this.loginWindow = loginWindow;
    }
}
