package de.jgsoftware.lanserver.model.mawi;

import javax.persistence.*;
import de.jgsoftware.lanserver.model.interfaces.mawi.iMBuchungsarten;
/**
 *
 * @author hoscho
 */

@Entity
@Table(name = "BUCHUNGSARTEN", schema = "PUBLIC", catalog = "MAWI")
public class Buchungsarten implements iMBuchungsarten
{

    @Id
    private Integer id;
    private String buchungsvorgang;
    private Integer buchungsart;
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String getBuchungsvorgang() {
        return buchungsvorgang;
    }
    @Override
    public void setBuchungsvorgang(String buchungsvorgang) {
        this.buchungsvorgang = buchungsvorgang;
    }
    @Override
    public Integer getBuchungsart() {
        return buchungsart;
    }
    @Override
    public void setBuchungsart(Integer buchungsart) {
        this.buchungsart = buchungsart;
    }
}
