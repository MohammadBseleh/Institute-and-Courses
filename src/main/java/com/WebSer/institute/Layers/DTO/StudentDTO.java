package com.WebSer.institute.Layers.DTO;

public class StudentDTO {
    private String name;
    private Integer studentNumber;
    private Integer hoursOfEnrollment;
    public StudentDTO() {
    }

    public StudentDTO(String name, Integer studentNumber, Integer hoursOfEnrollment) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.hoursOfEnrollment = hoursOfEnrollment;
    }

    public String getName() {
        return name;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public Integer getHoursOfEnrollment() {
        return hoursOfEnrollment;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", studentNumber=" + studentNumber +
                ", hoursOfEnrollment=" + hoursOfEnrollment +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setHoursOfEnrollment(Integer hoursOfEnrollment) {
        this.hoursOfEnrollment = hoursOfEnrollment;
    }
}
