package de.jgsoftware.lanserver.model.mawi;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "BUCHUNGSDATEN", schema = "PUBLIC", catalog = "MAWI")
public class Buchungsdaten
{

    @Id
    private int id;

    private Long kdnummer;
    private String kdname;
    private int beleg;
    private int wg;
    private double vk;
    private double ek;
    private Date bdatum;
    private Long artikelnummer;
    private int belegart;

    private int menge;

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getKdnummer() {
        return kdnummer;
    }

    public void setKdnummer(Long kdnummer) {
        this.kdnummer = kdnummer;
    }

    public String getKdname() {
        return kdname;
    }

    public void setKdname(String kdname) {
        this.kdname = kdname;
    }

    public int getBeleg() {
        return beleg;
    }

    public void setBeleg(int beleg) {
        this.beleg = beleg;
    }

    public int getWg() {
        return wg;
    }

    public void setWg(int wg) {
        this.wg = wg;
    }

    public double getVk() {
        return vk;
    }

    public void setVk(double vk) {
        this.vk = vk;
    }

    public double getEk() {
        return ek;
    }

    public void setEk(double ek) {
        this.ek = ek;
    }

    public Date getBdatum() {
        return bdatum;
    }

    public void setBdatum(Date bdatum) {
        this.bdatum = bdatum;
    }

    public Long getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(Long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public int getBelegart() {
        return belegart;
    }

    public void setBelegart(int belegart) {
        this.belegart = belegart;
    }
}
