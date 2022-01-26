package com.random.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "students")
@DynamicInsert
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int a_id;

    @Column(name = "teamId")
    private int b_teamId;

    @Column(name = "name")
    private String c_name;

    @Column(name = "surname")
    private String d_surname;

    @Column(name = "isPresent", columnDefinition = "boolean default true")
    private boolean e_isPresent = true;

    @Column(name = "mark", columnDefinition = "double default 0.0")
    private double f_mark;

    @Column(name = "ansMark", columnDefinition = "double default 0.0")
    private double g_ansMark;

    @Column(name = "qMark", columnDefinition = "double default 0.0")
    private double k_qMark;

    @Column(name = "isAnswer", columnDefinition = "boolean default false")
    private boolean l_isAnswer = false;

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getB_teamId() {
        return b_teamId;
    }

    public void setB_teamId(int b_teamId) {
        this.b_teamId = b_teamId;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getD_surname() {
        return d_surname;
    }

    public void setD_surname(String d_surname) {
        this.d_surname = d_surname;
    }

    public boolean isE_isPresent() {
        return e_isPresent;
    }

    public void setE_isPresent(boolean e_isPresent) {
        this.e_isPresent = e_isPresent;
    }

    public double getF_mark() {
        return f_mark;
    }

    public void setF_mark(double f_mark) {
        this.f_mark = f_mark;
    }

    public double getG_ansMark() {
        return g_ansMark;
    }

    public void setG_ansMark(double g_ansMark) {
        this.g_ansMark = g_ansMark;
    }

    public double getK_qMark() {
        return k_qMark;
    }

    public void setK_qMark(double k_qMark) {
        this.k_qMark = k_qMark;
    }

    public boolean isL_isAnswer() {
        return l_isAnswer;
    }

    public void setL_isAnswer(boolean l_isAnswer) {
        this.l_isAnswer = l_isAnswer;
    }

}
