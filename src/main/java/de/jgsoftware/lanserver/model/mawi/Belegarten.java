package de.jgsoftware.lanserver.model.mawi;

import javax.persistence.*;
import de.jgsoftware.lanserver.model.interfaces.mawi.iMBelegarten;
/**
 *
 * @author hoscho
 */
@Entity
@Table(name = "Belegarten", schema = "PUBLIC", catalog = "MAWI")
public class Belegarten implements iMBelegarten
{
    @Id
    private Integer id;
    private String belegart;
    private Integer belegnummernkreis;

    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public String getBelegart() {
        return belegart;
    }
    @Override
    public void setBelegart(String belegart) {
        this.belegart = belegart;
    }
    @Override
    public Integer getBelegnummernkreis() {
        return belegnummernkreis;
    }
    @Override
    public void setBelegnummernkreis(Integer belegnummernkreis) {
        this.belegnummernkreis = belegnummernkreis;
    }
}
