package com.WebSer.institute.Layers.domains;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.crypto.Data;
import java.time.Instant;
import java.util.Objects;
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(generator = "courses_id_seq")
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getName().equals(course.getName()) && getHours().equals(course.getHours()) && getLecturer().equals(course.getLecturer()) && getStartDate().equals(course.getStartDate()) && getEndDate().equals(course.getEndDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHours(), getLecturer(), getStartDate(), getEndDate());
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
