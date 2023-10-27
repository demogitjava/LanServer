package de.jgsoftware.lanserver.model.mawi;

import javax.persistence.*;
import de.jgsoftware.lanserver.model.interfaces.mawi.iMSpringSession;
/**
 *
 * @author hoscho
 */
@Entity
@Table(name = "SPRING_SESSION", schema = "PUBLIC", catalog = "MAWI")
public class SpringSession implements iMSpringSession
{
    @Id
    private Integer primaryId;
    private Integer sessionId;
    private Long creationTime;
    private Long lastAccessTime;
    private Integer maxInactiveInterval;
    private Long expiryTime;
    private String principalName;


    public Integer getPrimaryId() {
        return primaryId;
    }

    public void setPrimaryId(Integer primaryId) {
        this.primaryId = primaryId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    public Long getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Long lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getMaxInactiveInterval() {
        return maxInactiveInterval;
    }

    public void setMaxInactiveInterval(Integer maxInactiveInterval) {
        this.maxInactiveInterval = maxInactiveInterval;
    }

    public Long getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Long expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }
}
