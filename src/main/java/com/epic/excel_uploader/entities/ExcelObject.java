package com.epic.excel_uploader.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.security.PrivateKey;
import java.util.Date;

@Entity
    public class ExcelObject {

    @Id
    @GeneratedValue
    private int id;
    private Double testDate;
    private String Regeon;
    private String Rep;
    private String Item;
    private Double units;
    private Double costs;
    private Double total;

    public ExcelObject() {
    }

    public ExcelObject(int id, Double testDate, String regeon, String rep, String item, Double units, Double costs, Double total) {
        this.id = id;
        this.testDate = testDate;
        Regeon = regeon;
        Rep = rep;
        Item = item;
        this.units = units;
        this.costs = costs;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTestDate() {
        return testDate;
    }

    public void setTestDate(double testDate) {
        this.testDate = testDate;
    }

    public String getRegeon() {
        return Regeon;
    }

    public void setRegeon(String regeon) {
        Regeon = regeon;
    }

    public String getRep() {
        return Rep;
    }

    public void setRep(String rep) {
        Rep = rep;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public Double getUnits() {
        return units;
    }

    public void setUnits(Double units) {
        this.units = units;
    }

    public Double getCosts() {
        return costs;
    }

    public void setCosts(Double costs) {
        this.costs = costs;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ExcelObject{" +
                "id=" + id +
                ", testDate='" + testDate + '\'' +
                ", Regeon='" + Regeon + '\'' +
                ", Rep='" + Rep + '\'' +
                ", Item='" + Item + '\'' +
                ", units=" + units +
                ", costs=" + costs +
                ", total=" + total +
                '}';
    }
}
