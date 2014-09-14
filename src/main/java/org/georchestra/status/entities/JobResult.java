package org.georchestra.status.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name = "jobresults")
public class JobResult {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Service.class)
    private Service service;

    @Column(name = "date")
    private Date date;

    @Column(name = "result")
    private String result;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public JSONObject getResult() {
        return new JSONObject(result);
    }

    public void setResult(String result) {
        this.result = result;
    }


}
