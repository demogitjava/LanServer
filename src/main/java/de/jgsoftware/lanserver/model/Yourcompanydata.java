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
}
