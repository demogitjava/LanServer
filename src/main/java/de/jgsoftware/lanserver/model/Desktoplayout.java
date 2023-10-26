package de.jgsoftware.lanserver.model;


import javax.persistence.*;

import main.java.de.jgsoftware.lanserver.model.interfaces.iMDesktoplayout;
/**
 *
 * @author hoscho
 */
@Entity
@Table(name = "", schema = "PUBLIC", catalog = "")
public class Desktoplayout implements iMDesktoplayout
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String framename;
    private String de;
    private String fr;
    private String uk;
    private String esp;
    private String it;
    private String tr;
    private String bindto;
    private String guicomponentname;

    @Override
    public String getGuicomponentname() {
        return guicomponentname;
    }
    @Override
    public void setGuicomponentname(String guicomponentname) {
        this.guicomponentname = guicomponentname;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String getFramename() {
        return framename;
    }
    @Override
    public void setFramename(String framename) {
        this.framename = framename;
    }
    @Override
    public String getDe() {
        return de;
    }
    @Override
    public void setDe(String de) {
        this.de = de;
    }
    @Override
    public String getFr() {
        return fr;
    }
    @Override
    public void setFr(String fr) {
        this.fr = fr;
    }
    @Override
    public String getUk() {
        return uk;
    }
    @Override
    public void setUk(String uk) {
        this.uk = uk;
    }
    @Override
    public String getEsp() {
        return esp;
    }
    @Override
    public void setEsp(String esp) {
        this.esp = esp;
    }
    @Override
    public String getIt() {
        return it;
    }
    @Override
    public void setIt(String it) {
        this.it = it;
    }
    @Override
    public String getTr() {
        return tr;
    }
    @Override
    public void setTr(String tr) {
        this.tr = tr;
    }
    @Override
    public String getBindto() {
        return bindto;
    }
    @Override
    public void setBindto(String bindto) {
        this.bindto = bindto;
    }
}
