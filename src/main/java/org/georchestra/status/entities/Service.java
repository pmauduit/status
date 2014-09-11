package org.georchestra.status.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "services")
public class Service {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "instance_id")
    private int instanceId;

    private Instance instance;


    @ManyToOne(fetch = FetchType.LAZY)
    public Instance getInstance() {
        return this.instance;
    }

}
