package com.WebSer.institute.Layers.domains;

import javax.xml.crypto.Data;

public class Course {
    private String name;
    private Integer hours;
    private String lecturer;
    private Data startDate;
    private Data endDate;

    public Course(String name, Integer hours, String lecturer, Data startDate, Data endDate) {
        this.name = name;
        this.hours = hours;
        this.lecturer = lecturer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public Integer getHours() {
        return hours;
    }

    public String getLecturer() {
        return lecturer;
    }

    public Data getStartDate() {
        return startDate;
    }

    public Data getEndDate() {
        return endDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public void setStartDate(Data startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Data endDate) {
        this.endDate = endDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
