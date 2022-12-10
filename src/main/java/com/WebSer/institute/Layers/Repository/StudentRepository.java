package com.WebSer.institute.Layers.Repository;

import com.WebSer.institute.Layers.domains.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Student getStudent(Long id)
    {
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        Student student = jdbcTemplate.queryForObject("select * from students where id =?",rowMapper , id);
        return student;
    }
}
