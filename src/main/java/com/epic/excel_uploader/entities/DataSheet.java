package com.epic.excel_uploader.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DataSheet {

    @Id
    Double id;
    String name;
    String region;

    public DataSheet() {
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
