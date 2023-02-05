package com.WebSer.institute.Layers.Repository;

import com.WebSer.institute.Layers.domains.Course;
import com.WebSer.institute.Layers.domains.Student;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbcTemplate;
    RowMapper<Student> rowMapper;
    public StudentRepository(JdbcTemplate jdbcTemplate , RowMapper<Student> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper=rowMapper;
    }

    public Student getStudent(Long id)
    {
        try {
            Student student = jdbcTemplate.queryForObject("select * from students where id =?",rowMapper , id);
            return student;
        }catch (EmptyResultDataAccessException e)
        {
            return null;
        }

    }
    public Student createStudent(Student student)
    {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO public.students(\n" +
                        "\tname, student_number, hours_of_enrollment)\n" +
                        "\tVALUES (?, ?, ?)", new String[]{"id"} );
                preparedStatement.setString(1,student.getName());
                preparedStatement.setInt(2,student.getStudentNumber());
                preparedStatement.setInt(3,student.getHoursOfEnrollment());
                return preparedStatement;
            }
        },keyHolder);

        long generatedKey = keyHolder.getKey().longValue();
        return getStudent(generatedKey);
    }
    public void deleteStudent(long id)
    {
        jdbcTemplate.update("DELETE FROM public.students\n" +
                "\tWHERE id = ?" , id);
    }
    public Student updateStudent(long id,Student student)
    {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement("UPDATE public.students\n" +
                        "\tSET name=?, student_number=?, hours_of_enrollment=?\n" +
                        "\tWHERE id = ?" );
                preparedStatement.setString(1,student.getName());
                preparedStatement.setInt(2,student.getStudentNumber());
                preparedStatement.setInt(3,student.getHoursOfEnrollment());
                return preparedStatement;

            }
        });
        return getStudent(id);
    }
}
