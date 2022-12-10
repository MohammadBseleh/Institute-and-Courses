package com.WebSer.institute.Layers.Repository;

import com.WebSer.institute.Layers.domains.Course;
import com.WebSer.institute.Layers.domains.Teacher;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepository {
    private JdbcTemplate jdbcTemplate;

    public TeacherRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Teacher getTeacher(Long id)
    {
        RowMapper<Teacher> rowMapper = new BeanPropertyRowMapper<>(Teacher.class);
        Teacher teacher = jdbcTemplate.queryForObject("select * from teachers where id =?",rowMapper , id);
        return teacher;
    }
}
