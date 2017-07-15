package com.company.sample.entity;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@Table(name = "SAMPLE_HOST")
@Entity(name = "sample$Host")
public class Host extends StandardEntity {
    private static final long serialVersionUID = -7849605582801806394L;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "IP_ADDRESS")
    @Convert(converter = InetConverter.class)
    protected String ip_address;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getIp_address() {
        return ip_address;
    }


}