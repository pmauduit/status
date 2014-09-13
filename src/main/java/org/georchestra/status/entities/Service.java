package org.georchestra.status.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.georchestra.status.services.AbstractServiceType;
import org.json.JSONObject;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="service_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pk_sequence")
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Instance.class)
    private Instance instance;

    @Column(name = "uri_path")
    private String uriPath;

    @Column(name =  "class")
    private Class<AbstractServiceType> className;

    public Instance getInstance() {
        return this.instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUriPath() {
        return uriPath;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }

    public Class<AbstractServiceType> getClassName() {
        return className;
    }

    public void setClassName(Class<AbstractServiceType> className) {
        this.className = className;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    public JSONObject toJSON() {
        return new JSONObject().put("id", id)
                .put("uri_path", uriPath);
    }

}
