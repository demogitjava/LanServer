package de.jgsoftware.lanserver.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import de.jgsoftware.lanserver.model.interfaces.iMYourcompanydata;
@Entity
@Table(name = "YOURCOMANYDATA", schema = "PUBLIC", catalog = "DEMODB")
public class Yourcompanydata implements iMYourcompanydata
{

    @Id
    private Integer id;
   
    private String firmenname;
    private String strasse;

    private Integer plz;
    private String ort;
    private String telefon;
    private String email;
    private Integer firmennumer;

    private String steuernummer;
    private String UstIdNr;
    private String geschäftsführer;
    private String amtsgericht;
    private String bank;
    private String kontoinhaber;
    private String iban;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFirmennumer() {
        return firmennumer;
    }

    public void setFirmennumer(Integer firmennumer) {
        this.firmennumer = firmennumer;
    }


    public String getSteuernummer() {
        return steuernummer;
    }

    public void setSteuernummer(String steuernummer) {
        this.steuernummer = steuernummer;
    }

    public String getUstIdNr() {
        return UstIdNr;
    }

    public void setUstIdNr(String ustIdNr) {
        UstIdNr = ustIdNr;
    }

    public String getGeschäftsführer() {
        return geschäftsführer;
    }

    public void setGeschäftsführer(String geschäftsführer) {
        this.geschäftsführer = geschäftsführer;
    }

    public String getAmtsgericht() {
        return amtsgericht;
    }

    public void setAmtsgericht(String amtsgericht) {
        this.amtsgericht = amtsgericht;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
