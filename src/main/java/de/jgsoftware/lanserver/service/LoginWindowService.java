package de.jgsoftware.lanserver.service;

import de.jgsoftware.lanserver.dao.DaoLoginWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginWindowService implements de.jgsoftware.lanserver.service.interfaces.iLoginWindowService
{


    @Autowired
    DaoLoginWindow loginWindow;

    public LoginWindowService(DaoLoginWindow loginWindow)
    {

    }

    public DaoLoginWindow getLoginWindow() {
        return loginWindow;
    }

    public void setLoginWindow(DaoLoginWindow loginWindow) {
        this.loginWindow = loginWindow;
    }
}
