package com.WebSer.institute.Layers.DTO;

import java.util.Objects;

public class TeacherDTO {
    private String name;
    private Integer workingHours;
    private boolean fullTime;
    private String course;

    public TeacherDTO() {
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "name='" + name + '\'' +
                ", workingHours=" + workingHours +
                ", fullTime=" + fullTime +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherDTO that = (TeacherDTO) o;
        return fullTime == that.fullTime && Objects.equals(name, that.name) && Objects.equals(workingHours, that.workingHours) && Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workingHours, fullTime, course);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public TeacherDTO(String name, Integer workingHours, boolean fullTime, String course) {
        this.name = name;
        this.workingHours = workingHours;
        this.fullTime = fullTime;
        this.course = course;
    }
}
