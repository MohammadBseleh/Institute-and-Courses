package com.WebSer.institute.Layers.DTO;

import java.time.Instant;

public class CourseDTO {
    private String name;
    private Integer hours;
    private String lecturer;
    private Instant startDate;
    private Instant endDate;

    @Override
    public String toString() {
        return "CourseDTO{" +
                "name='" + name + '\'' +
                ", hours=" + hours +
                ", lecturer='" + lecturer + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public CourseDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }

    public CourseDTO(String name, Integer hours, String lecturer, Instant startDate, Instant endDate) {
        this.name = name;
        this.hours = hours;
        this.lecturer = lecturer;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
