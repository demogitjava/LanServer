package de.jgsoftware.lanserver.model.interfaces.mawi;

/**
 *
 * @author hoscho
 */

public interface iMSpringSessionAttributes
{
    public Integer getSessionPrimaryId();
    public void setSessionPrimaryId(Integer sessionPrimaryId);
    public String getAttributeName();
    public void setAttributeName(String attributeName);
    public byte[] getAttributeBytes();
    public void setAttributeBytes(byte[] attributeBytes);
}
