package com.example.korail.entity;

import javax.persistence.*;

@Entity
@Table(name="ktx_station")
public class Station {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="station")
    private String station;

    @Column(name="location")
    private String location;

    @Column(name="sphone")
    private String sphone;

    @Column(name="category")
    private String category;

    @Column(name="info")
    private String info;

    @Column(name="history")
    private String history;

    @Column(name="clink1")
    private String clink1;

    @Column(name="clink2")
    private String clink2;

    @Column(name="mlink")
    private String mlink;

    @Column(name="plink")
    private String plink;

    // define constructors
    public Station() {

    }

    public Station(String station, String location, String sphone, String category, String info, String history, String clink1, String clink2, String mlink, String plink) {
        this.station = station;
        this.location = location;
        this.sphone = sphone;
        this.category = category;
        this.info = info;
        this.history = history;
        this.clink1 = clink1;
        this.clink2 = clink2;
        this.mlink = mlink;
        this.plink = plink;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getClink1() {
        return clink1;
    }

    public void setClink1(String clink1) {
        this.clink1 = clink1;
    }

    public String getClink2() {
        return clink2;
    }

    public void setClink2(String clink2) {
        this.clink2 = clink2;
    }

    public String getMlink() {
        return mlink;
    }

    public void setMlink(String mlink) {
        this.mlink = mlink;
    }

    public String getPlink() {
        return plink;
    }

    public void setPlink(String plink) {
        this.plink = plink;
    }

    // define toString

    @Override
    public String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                ", station='" + station + '\'' +
                ", location='" + location + '\'' +
                ", sphone='" + sphone + '\'' +
                ", category='" + category + '\'' +
                ", info='" + info + '\'' +
                ", history='" + history + '\'' +
                ", clink1='" + clink1 + '\'' +
                ", clink2='" + clink2 + '\'' +
                ", mlink='" + mlink + '\'' +
                ", plink='" + plink + '\'' +
                '}';
    }
}
