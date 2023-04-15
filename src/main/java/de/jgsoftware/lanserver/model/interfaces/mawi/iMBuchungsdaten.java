package de.jgsoftware.lanserver.model.interfaces.mawi;

import java.util.Date;


/**
 *
 * @author hoscho
 */
public interface iMBuchungsdaten
{
    public Integer getId();
    public void setId(Integer id);
    public Long getKdnummer();
    public void setKdnummer(Long kdnummer);
    public String getKdname();
    public void setKdname(String kdname);
    public int getBeleg();
    public void setBeleg(int beleg);
    public int getWg();
    public void setWg(int wg);
    public double getVk();
    public void setVk(double vk);
    public Date getBdatum();
    public void setBdatum(Date bdatum);
    public Long getArtikelnummer();
    public void setArtikelnummer(Long artikelnummer);
    public int getBelegart();
    public void setBelegart(int belegart);
    public int getMenge();
    public void setMenge(int menge);
    public Integer getBuchungskz();
    public void setBuchungskz(Integer buchungskz);
}
