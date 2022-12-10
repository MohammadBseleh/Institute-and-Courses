package com.WebSer.institute.Layers.Repository;

import com.WebSer.institute.Layers.domains.Course;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

    private JdbcTemplate jdbcTemplate;

    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Course getCourse(Long id)
    {
        RowMapper<Course> rowMapper = new BeanPropertyRowMapper<>(Course.class);
        Course course = jdbcTemplate.queryForObject("select * from Courses where id =?",rowMapper , id);
        return course;
    }

}
