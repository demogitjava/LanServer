package de.jgsoftware.lanserver.model.mawi;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import de.jgsoftware.lanserver.model.interfaces.mawi.iMBuchungsdaten;

@Entity
@Table(name = "BUCHUNGSDATEN", schema = "PUBLIC", catalog = "MAWI")
public class Buchungsdaten implements iMBuchungsdaten {

    @Id
    @GeneratedValue
    private Integer id;

    private Long kdnummer;
    private String kdname;
    private int beleg;
    private int wg;
    private double vk;
    private Date bdatum;
    private Long artikelnummer;
    private int belegart;
    private int menge;
    private Integer buchungskz;

    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public Long getKdnummer() {
        return kdnummer;
    }
    @Override
    public void setKdnummer(Long kdnummer) {
        this.kdnummer = kdnummer;
    }
    @Override
    public String getKdname() {
        return kdname;
    }
    @Override
    public void setKdname(String kdname) {
        this.kdname = kdname;
    }
    @Override
    public int getBeleg() {
        return beleg;
    }
    @Override
    public void setBeleg(int beleg) {
        this.beleg = beleg;
    }
    @Override
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

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public Integer getBuchungskz() {
        return buchungskz;
    }

    public void setBuchungskz(Integer buchungskz) {
        this.buchungskz = buchungskz;
    }
}
