package de.jgsoftware.lanserver.model.mawi;

import javax.persistence.*;

@Entity
@Table(name = "BUCHUNGSARTEN", schema = "PUBLIC", catalog = "MAWI")
public class Buchungsarten {

    @Id
    private Integer id;
    private String buchungsvorgang;
    private Integer buchungsart;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuchungsvorgang() {
        return buchungsvorgang;
    }

    public void setBuchungsvorgang(String buchungsvorgang) {
        this.buchungsvorgang = buchungsvorgang;
    }

    public Integer getBuchungsart() {
        return buchungsart;
    }

    public void setBuchungsart(Integer buchungsart) {
        this.buchungsart = buchungsart;
    }
}