package com.WebSer.institute.Layers.domains;


import java.util.Arrays;
import java.util.Objects;

public class Teacher {
private String name;
private Integer workingHours;
private boolean fullTime;
private String course;

    public Teacher(String name, Integer workingHours, boolean fullTime, String course) {
        this.name = name;
        this.workingHours = workingHours;
        this.fullTime = fullTime;
        this.course = course;
    }

    public Teacher() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return fullTime == teacher.fullTime && name.equals(teacher.name) && workingHours.equals(teacher.workingHours) && course.equals(teacher.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, workingHours, fullTime, course);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", workingHours=" + workingHours +
                ", fullTime=" + fullTime +
                ", course='" + course + '\'' +
                '}';
    }
}
