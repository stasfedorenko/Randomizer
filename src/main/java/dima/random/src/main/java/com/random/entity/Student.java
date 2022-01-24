package com.random.entity;

import javax.persistence.*;

public class Student {
    private int id;
    private String name;
    private String surname;
    private String isPresent;
    private double mark;

    public Student(int id, String name, String surname, String isPresent, double mark) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.isPresent = isPresent;
        this.mark = mark;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(String isPresent) {
        this.isPresent = isPresent;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
