package com.WebSer.institute.Layers.AppConfig;

import com.WebSer.institute.Layers.domains.Student;
import com.WebSer.institute.Layers.domains.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import com.WebSer.institute.Layers.domains.Course;

@Configuration
public class Config {
    @Bean
    public RowMapper<Course> courseRowMapper(){
        return new BeanPropertyRowMapper<>(Course.class);
    }
    @Bean
    public RowMapper<Student> studentRowMapper(){
        return new BeanPropertyRowMapper<>(Student.class);
    }
    @Bean
    public RowMapper<Teacher> teacherRowMapper(){
        return new BeanPropertyRowMapper<>(Teacher.class);
    }

}
