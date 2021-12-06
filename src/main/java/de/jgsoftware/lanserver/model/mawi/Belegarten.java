package de.jgsoftware.lanserver.model.mawi;

import javax.persistence.*;
import de.jgsoftware.lanserver.model.interfaces.mawi.iMBelegarten;

@Entity
@Table(name = "Belegarten", schema = "PUBLIC", catalog = "MAWI")
public class Belegarten implements iMBelegarten
{
    @Id
    private Integer id;
    private String belegart;
    private Integer belegnummernkreis;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBelegart() {
        return belegart;
    }

    public void setBelegart(String belegart) {
        this.belegart = belegart;
    }

    public Integer getBelegnummernkreis() {
        return belegnummernkreis;
    }

    public void setBelegnummernkreis(Integer belegnummernkreis) {
        this.belegnummernkreis = belegnummernkreis;
    }
}
