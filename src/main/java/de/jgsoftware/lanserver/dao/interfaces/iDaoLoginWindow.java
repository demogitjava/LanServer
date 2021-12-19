package de.jgsoftware.lanserver.dao.interfaces;

import de.jgsoftware.lanserver.model.Desktoplayout;

import java.util.List;

public interface iDaoLoginWindow
{
    public List<Desktoplayout> getlogintextentry();
    public List<Desktoplayout> getFrameDesktopEntry(String framename);
}
