package de.jgsoftware.lanserver.model.interfaces.mawi;

import java.util.Date;

public interface iMArtikelstamm
{
    public int getId();
    public void setId(int id);
    public String getArtikelbezeichnung();
    public void setArtikelbezeichnung(String artikelbezeichnung);
    public int getWg();
    public void setWg(int wg);
    public double getEk();
    public void setEk(double ek);
    public double getVk();
    public void setVk(double vk);
    public Date getLetzebuchnung();
    public void setLetzebuchnung(Date letzebuchnung);
    public Long getArtikelnummer();
    public void setArtikelnummer(Long artikelnummer);
    public java.sql.Date getLetzebuchung();
    public void setLetzebuchung(java.sql.Date letzebuchung);
    public Integer getSelectionclient();
    public void setSelectionclient(Integer selectionclient);
}
