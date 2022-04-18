package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="id")
    private int studID;

    @Column(name="name")
    private String studName;

    @Column(name="city")
    private String studCity;

    public Student(int studID, String studName, String studCity) {
        this.studID = studID;
        this.studName = studName;
        this.studCity = studCity;
    }

    public Student() {
        super();
    }

    public int getStudID() {
        return studID;
    }

    public void setStudID(int studID) {
        this.studID = studID;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudCity() {
        return studCity;
    }

    public void setStudCity(String studCity) {
        this.studCity = studCity;
    }
}