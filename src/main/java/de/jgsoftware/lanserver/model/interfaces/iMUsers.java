package de.jgsoftware.lanserver.model.interfaces;

public interface iMUsers
{
    public long getId();
    public void setId(long id);
    public String getUsername();
    public void setUsername(String username);
    public String getPassword();
    public void setPassword(String password);
    public String getRole();
    public void setRole(String role);

    public Integer getEnabled();
    public void setEnabled(Integer enabled);
}
