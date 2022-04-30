package de.jgsoftware.lanserver.service.interfaces;

import de.jgsoftware.lanserver.dao.DaoLoginWindow;
import org.springframework.stereotype.Service;

@Service
public interface iLoginWindowService
{
    DaoLoginWindow getLoginWindow();
    void setLoginWindow(DaoLoginWindow loginWindow);

}
