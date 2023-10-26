package de.jgsoftware.lanserver.model.mawi;



import java.util.Date;

import javax.persistence.*;

import main.java.de.jgsoftware.lanserver.model.interfaces.mawi.iMArtikelstamm;
/**
 *
 * @author hoscho
 */
@Entity
@Table(name = "ARTIKELSTAMM", schema = "PUBLIC", catalog = "MAWI")
public class Artikelstamm implements iMArtikelstamm
{
    @Id
    private int id;
    private String artikelbezeichnung;
    private int wg;
    private double ek;
    private double vk;
    private Date letzebuchnung;
    private Long artikelnummer;
    private java.sql.Date letzebuchung;
    private Integer selectionclient;

    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getArtikelbezeichnung() {
        return artikelbezeichnung;
    }
    @Override
    public void setArtikelbezeichnung(String artikelbezeichnung) {
        this.artikelbezeichnung = artikelbezeichnung;
    }
    @Override
    public int getWg() {
        return wg;
    }
    @Override
    public void setWg(int wg) {
        this.wg = wg;
    }
    @Override
    public double getEk() {
        return ek;
    }
    @Override
    public void setEk(double ek) {
        this.ek = ek;
    }
    @Override
    public double getVk() {
        return vk;
    }
    @Override
    public void setVk(double vk) {
        this.vk = vk;
    }
    @Override
    public Date getLetzebuchnung() {
        return letzebuchnung;
    }
    @Override
    public void setLetzebuchnung(Date letzebuchnung) {
        this.letzebuchnung = letzebuchnung;
    }
    @Override
    public Long getArtikelnummer() {
        return artikelnummer;
    }
    @Override
    public void setArtikelnummer(Long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }
    @Override
    public java.sql.Date getLetzebuchung() {
        return letzebuchung;
    }
    @Override
    public void setLetzebuchung(java.sql.Date letzebuchung) {
        this.letzebuchung = letzebuchung;
    }
    @Override
    public Integer getSelectionclient() {
        return selectionclient;
    }
    @Override
    public void setSelectionclient(Integer selectionclient) {
        this.selectionclient = selectionclient;
    }
}
