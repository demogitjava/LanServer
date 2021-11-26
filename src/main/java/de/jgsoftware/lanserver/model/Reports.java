package de.jgsoftware.lanserver.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Lob;

@Entity
@Table(name = "Reports", schema = "PUBLIC", catalog = "DEMODB")
public class Reports
{
    @Id
    private Integer id;

    private String reportname;

    @Lob
    private byte[] reportdata;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportname() {
        return reportname;
    }

    public void setReportname(String reportname) {
        this.reportname = reportname;
    }


    public byte[] getReportdata() {
        return reportdata;
    }

    public void setReportdata(byte[] reportdata) {
        this.reportdata = reportdata;
    }
}
