package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.Desktoplayout;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface iDaoLoginWindow
{
    public List<Desktoplayout> getlogintextentry();
    public List<Desktoplayout> getFrameDesktopEntry(String framename);
}
