package de.jgsoftware.lanserver.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import de.jgsoftware.lanserver.model.interfaces.iMKundenstamm;
/**
 *
 * @author hoscho
 */
@Entity(name = "Kundenstamm")
public class MKundenstamm implements iMKundenstamm
{



    @Id
    private Long id;

    private Long kundennummer;

    private String kundenname;

    private String land;

    private String name_Anschrift1;

    private String name_Anschrift2;

    private String name_Anschrift3;

    private String name_Anschrift4;

    private String strasse;

    private Integer plz;

    private String ort;

    private String iban;

    private String blz;

    private String konto_Nr;

    private Double kreditlimit;

    private String telefon;

    private String mobil1;

    private String mobil2;

    private String sip;

    private String email;

    private String ansprechpartner;

    private Float umsatz_Lfd_Jahr;

    private Float umsatz_Jahr_1;

    private Float umsatz_Jahr_2;

    private Date timestamp;

    private int gebiet;

    private int vertreter;

    private String bankverbindung;



    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public int getGebiet() {
        return gebiet;
    }
    @Override
    public void setGebiet(int gebiet) {
        this.gebiet = gebiet;
    }
    @Override
    public int getVertreter() {
        return vertreter;
    }
    @Override
    public void setVertreter(int vertreter) {
        this.vertreter = vertreter;
    }
    @Override
    public String getBankverbindung() {
        return bankverbindung;
    }
    @Override
    public void setBankverbindung(String bankverbindung) {
        this.bankverbindung = bankverbindung;
    }
    @Override
    public String getKundenname() {
        return kundenname;
    }
    @Override
    public void setKundenname(String kundenname) {
        this.kundenname = kundenname;
    }
    @Override
    public Long getKundennummer() {
        return kundennummer;
    }
    @Override
    public void setKundennummer(Long kundennummer) {
        this.kundennummer = kundennummer;
    }
    @Override
    public String getLand() {
        return land;
    }
    @Override
    public void setLand(String land) {
        this.land = land;
    }
    @Override
    public String getStrasse() {
        return strasse;
    }
    @Override
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    @Override
    public Integer getPlz() {
        return plz;
    }
    @Override
    public void setPlz(Integer plz) {
        this.plz = plz;
    }
    @Override
    public String getOrt() {
        return ort;
    }
    @Override
    public void setOrt(String ort) {
        this.ort = ort;
    }
    @Override
    public String getIban() {
        return iban;
    }
    @Override
    public void setIban(String iban) {
        this.iban = iban;
    }
    @Override
    public String getBlz() {
        return blz;
    }
    @Override
    public void setBlz(String blz) {
        this.blz = blz;
    }
    @Override
    public String getKonto_Nr() {
        return konto_Nr;
    }
    @Override
    public void setKonto_Nr(String konto_Nr) {
        this.konto_Nr = konto_Nr;
    }
    @Override
    public Double getKreditlimit() {
        return kreditlimit;
    }
    @Override
    public void setKreditlimit(Double kreditlimit) {
        this.kreditlimit = kreditlimit;
    }
    @Override
    public String getTelefon() {
        return telefon;
    }
    @Override
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    @Override
    public String getMobil1() {
        return mobil1;
    }
    @Override
    public void setMobil1(String mobil1) {
        this.mobil1 = mobil1;
    }
    @Override
    public String getMobil2() {
        return mobil2;
    }
    @Override
    public void setMobil2(String mobil2) {
        this.mobil2 = mobil2;
    }
    @Override
    public String getSip() {
        return sip;
    }
    @Override
    public void setSip(String sip) {
        this.sip = sip;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getAnsprechpartner() {
        return ansprechpartner;
    }
    @Override
    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }
    @Override
    public Date getTimestamp() {
        return timestamp;
    }
    @Override
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String getName_Anschrift1() {
        return name_Anschrift1;
    }
    @Override
    public void setName_Anschrift1(String name_Anschrift1) {
        this.name_Anschrift1 = name_Anschrift1;
    }
    @Override
    public String getName_Anschrift2() {
        return name_Anschrift2;
    }
    @Override
    public void setName_Anschrift2(String name_Anschrift2) {
        this.name_Anschrift2 = name_Anschrift2;
    }
    @Override
    public String getName_Anschrift3() {
        return name_Anschrift3;
    }
    @Override
    public void setName_Anschrift3(String name_Anschrift3) {
        this.name_Anschrift3 = name_Anschrift3;
    }
    @Override
    public String getName_Anschrift4() {
        return name_Anschrift4;
    }
    @Override
    public void setName_Anschrift4(String name_Anschrift4) {
        this.name_Anschrift4 = name_Anschrift4;
    }
    @Override
    public Float getUmsatz_Lfd_Jahr() {
        return umsatz_Lfd_Jahr;
    }
    @Override
    public void setUmsatz_Lfd_Jahr(Float umsatz_Lfd_Jahr) {
        this.umsatz_Lfd_Jahr = umsatz_Lfd_Jahr;
    }
    @Override
    public Float getUmsatz_Jahr_1() {
        return umsatz_Jahr_1;
    }
    @Override
    public void setUmsatz_Jahr_1(Float umsatz_Jahr_1) {
        this.umsatz_Jahr_1 = umsatz_Jahr_1;
    }
    @Override
    public Float getUmsatz_Jahr_2() {
        return umsatz_Jahr_2;
    }
    @Override
    public void setUmsatz_Jahr_2(Float umsatz_Jahr_2) {
        this.umsatz_Jahr_2 = umsatz_Jahr_2;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kundennummer != null ? kundennummer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MKundenstamm)) {
            return false;
        }
        MKundenstamm other = (MKundenstamm) object;
        if ((this.kundennummer == null && other.kundennummer != null) || (this.kundennummer != null && !this.kundennummer.equals(other.kundennummer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.jsoft.model.data.Kundenstamm[ kundennummer=" + kundennummer + " ]";
    }

}
