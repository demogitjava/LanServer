package de.jgsoftware.lanserver.model.mawi;



import javax.persistence.*;
import javax.sql.DataSource;
import java.util.Date;


@Entity
@Table(name = "ARTIKELSTAMM", schema = "PUBLIC", catalog = "MAWI")
public class Artikelstamm
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtikelbezeichnung() {
        return artikelbezeichnung;
    }

    public void setArtikelbezeichnung(String artikelbezeichnung) {
        this.artikelbezeichnung = artikelbezeichnung;
    }

    public int getWg() {
        return wg;
    }

    public void setWg(int wg) {
        this.wg = wg;
    }

    public double getEk() {
        return ek;
    }

    public void setEk(double ek) {
        this.ek = ek;
    }

    public double getVk() {
        return vk;
    }

    public void setVk(double vk) {
        this.vk = vk;
    }

    public Date getLetzebuchnung() {
        return letzebuchnung;
    }

    public void setLetzebuchnung(Date letzebuchnung) {
        this.letzebuchnung = letzebuchnung;
    }

    public Long getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(Long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public java.sql.Date getLetzebuchung() {
        return letzebuchung;
    }

    public void setLetzebuchung(java.sql.Date letzebuchung) {
        this.letzebuchung = letzebuchung;
    }

    public Integer getSelectionclient() {
        return selectionclient;
    }

    public void setSelectionclient(Integer selectionclient) {
        this.selectionclient = selectionclient;
    }
}
