package org.georchestra.status.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name = "instances")
public class Instance {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "host")
    private String host;

    @Column(name = "https")
    private boolean isHttps;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "instance")
    private Set<Service> services = new HashSet<Service>();


    public Set<Service> getServices() {
        return this.services;
    }


    public Instance() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public boolean isHttps() {
        return isHttps;
    }

    public void setHttps(boolean isHttps) {
        this.isHttps = isHttps;
    }

    public JSONObject toJSON() {
        return new JSONObject().put("id", id)
                .put("host", host)
                .put("isHttps", isHttps);
    }
}
