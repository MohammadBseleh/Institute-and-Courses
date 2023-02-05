package com.WebSer.institute.Layers.domains;

import java.util.Objects;

public class Student {
    private String name;
    private Integer studentNumber;
    private Integer hoursOfEnrollment;

    public Student(String name, Integer studentNumber, Integer hoursOfEnrollment) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.hoursOfEnrollment = hoursOfEnrollment;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getHoursOfEnrollment() {
        return hoursOfEnrollment;
    }

    public void setHoursOfEnrollment(Integer hoursOfEnrollment) {
        this.hoursOfEnrollment = hoursOfEnrollment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name) && studentNumber.equals(student.studentNumber) && hoursOfEnrollment.equals(student.hoursOfEnrollment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentNumber, hoursOfEnrollment);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                ", hoursOfEnrollment=" + hoursOfEnrollment +
                '}';
    }
}
