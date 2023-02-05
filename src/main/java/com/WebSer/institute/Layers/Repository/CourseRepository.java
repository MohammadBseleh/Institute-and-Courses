package com.WebSer.institute.Layers.Repository;

import com.WebSer.institute.Layers.domains.Course;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
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
public class CourseRepository {

    private JdbcTemplate jdbcTemplate;
    RowMapper<Course> rowMapper;
    public CourseRepository(JdbcTemplate jdbcTemplate ,RowMapper<Course> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper=rowMapper;
    }

    public Course getCourse(Long id)
    {
        try{
            Course course = jdbcTemplate.queryForObject("select * from Courses where id =?",rowMapper , id);
            return course;
        }catch (EmptyResultDataAccessException e)
        {
            return null;
        }

    }
    public Course createCourse(Course course)
    {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
         jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
               PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO public.courses(\n" +
                       "\tname, start_date, end_date, hours, lecturer)\n" +
                       "\tVALUES (?, ?, ?, ?, ?)", new String[]{"id"} );
               preparedStatement.setString(1,course.getName());
               preparedStatement.setTimestamp(2,Timestamp.from(course.getStartDate()));
                preparedStatement.setTimestamp(3,Timestamp.from(course.getEndDate()));
                preparedStatement.setInt(4,course.getHours());
                preparedStatement.setString(5,course.getLecturer());
                return preparedStatement;

            }
        },keyHolder);

        long generatedKey = keyHolder.getKey().longValue();
        return getCourse(generatedKey);
    }
    public void deleteCourse(long id)
    {
        jdbcTemplate.update("DELETE FROM public.courses\n" +
                "\tWHERE id = ?" , id);
    }
    public Course updateCourse(long id,Course course)
    {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement("UPDATE public.courses\n" +
                        "\tSET name=?, start_date=?, end_date=?, hours=?, lecturer=?" +
                        "\tWHERE id= ?" );
                preparedStatement.setString(1,course.getName());
                preparedStatement.setTimestamp(2,Timestamp.from(course.getStartDate()));
                preparedStatement.setTimestamp(3,Timestamp.from(course.getEndDate()));
                preparedStatement.setInt(4,course.getHours());
                preparedStatement.setString(5,course.getLecturer());
                preparedStatement.setLong(6,id);
                return preparedStatement;

            }
        });
        return getCourse(id);
    }

}
