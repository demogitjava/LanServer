package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.Desktoplayout;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iDaoLoginWindow
{
    List<Desktoplayout> getlogintextentry();
    List<Desktoplayout> getFrameDesktopEntry(String framename);
}
