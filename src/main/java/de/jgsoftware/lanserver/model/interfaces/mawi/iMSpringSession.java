package de.jgsoftware.lanserver.model.interfaces.mawi;

public interface iMSpringSession
{

    public Integer getPrimaryId();
    public void setPrimaryId(Integer primaryId);
    public Integer getSessionId();
    public void setSessionId(Integer sessionId);
    public Long getCreationTime();
    public void setCreationTime(Long creationTime);
    public Long getLastAccessTime();
    public void setLastAccessTime(Long lastAccessTime);
    public Integer getMaxInactiveInterval();
    public void setMaxInactiveInterval(Integer maxInactiveInterval);
    public Long getExpiryTime();
    public void setExpiryTime(Long expiryTime);
    public String getPrincipalName();
    public void setPrincipalName(String principalName);
}
