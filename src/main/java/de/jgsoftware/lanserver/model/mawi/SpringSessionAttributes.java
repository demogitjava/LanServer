package de.jgsoftware.lanserver.model.mawi;

import javax.persistence.*;
import java.util.Arrays;
import de.jgsoftware.lanserver.model.interfaces.mawi.iMSpringSessionAttributes;
/**
 *
 * @author hoscho
 */
@Entity
@Table(name = "SPRING_SESSION_ATTRIBUTES", schema = "PUBLIC", catalog = "MAWI")
public class SpringSessionAttributes implements iMSpringSessionAttributes
{
    @Id
    private Integer sessionPrimaryId;
    private String attributeName;
    private byte[] attributeBytes;


    public Integer getSessionPrimaryId() {
        return sessionPrimaryId;
    }

    public void setSessionPrimaryId(Integer sessionPrimaryId) {
        this.sessionPrimaryId = sessionPrimaryId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public byte[] getAttributeBytes() {
        return attributeBytes;
    }

    public void setAttributeBytes(byte[] attributeBytes) {
        this.attributeBytes = attributeBytes;
    }
}
