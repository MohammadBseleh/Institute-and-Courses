package com.WebSer.institute.Layers.domains;

import javax.xml.crypto.Data;
import java.time.Instant;

public class Course {
    private String name;
    private Integer hours;
    private String lecturer;
    private Instant startDate;
    private Instant endDate;

    public Course(String name, Integer hours, String lecturer, Instant startDate, Instant endDate) {
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

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
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

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Instant endDate) {
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

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", lecturer='" + lecturer + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
