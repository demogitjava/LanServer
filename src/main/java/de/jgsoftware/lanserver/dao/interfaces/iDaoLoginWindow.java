package de.jgsoftware.lanserver.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import main.java.de.jgsoftware.lanserver.model.Desktoplayout;
/**
 *
 * @author hoscho
 */

@Repository
public interface iDaoLoginWindow
{
    List<Desktoplayout> getlogintextentry();
    List<Desktoplayout> getFrameDesktopEntry(String framename);
}
