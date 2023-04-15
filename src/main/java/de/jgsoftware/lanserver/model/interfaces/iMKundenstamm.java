package de.jgsoftware.lanserver.model.interfaces;

import de.jgsoftware.lanserver.model.MKundenstamm;

import java.util.Date;
/**
 *
 * @author hoscho
 */
public interface iMKundenstamm
{
    public Long getId();
    public void setId(Long id);
    public int getGebiet();
    public void setGebiet(int gebiet);
    public int getVertreter();
    public void setVertreter(int vertreter);
    public String getBankverbindung();
    public void setBankverbindung(String bankverbindung);
    public String getKundenname();
    public void setKundenname(String kundenname);
    public Long getKundennummer();
    public void setKundennummer(Long kundennummer);
    public String getLand();
    public void setLand(String land);
    public String getStrasse();
    public void setStrasse(String strasse);
    public Integer getPlz();
    public void setPlz(Integer plz);
    public String getOrt();
    public void setOrt(String ort);
    public String getIban();
    public void setIban(String iban);
    public String getBlz();
    public void setBlz(String blz);
    public String getKonto_Nr();
    public void setKonto_Nr(String konto_Nr);
    public Double getKreditlimit();
    public void setKreditlimit(Double kreditlimit);
    public String getTelefon();
    public void setTelefon(String telefon);
    public String getMobil1();
    public void setMobil1(String mobil1);
    public String getMobil2();
    public void setMobil2(String mobil2);
    public String getSip();
    public void setSip(String sip);
    public String getEmail();
    public void setEmail(String email);
    public String getAnsprechpartner();
    public void setAnsprechpartner(String ansprechpartner);
    public Date getTimestamp();
    public void setTimestamp(Date timestamp);
    public String getName_Anschrift1();
    public void setName_Anschrift1(String name_Anschrift1);
    public String getName_Anschrift2();
    public void setName_Anschrift2(String name_Anschrift2);
    public String getName_Anschrift3();
    public void setName_Anschrift3(String name_Anschrift3);
    public String getName_Anschrift4();
    public void setName_Anschrift4(String name_Anschrift4);
    public Float getUmsatz_Lfd_Jahr();
    public void setUmsatz_Lfd_Jahr(Float umsatz_Lfd_Jahr);
    public Float getUmsatz_Jahr_1();
    public void setUmsatz_Jahr_1(Float umsatz_Jahr_1);
    public Float getUmsatz_Jahr_2();
    public void setUmsatz_Jahr_2(Float umsatz_Jahr_2);

    public int hashCode();
    public boolean equals(Object object);
    public String toString();
}
