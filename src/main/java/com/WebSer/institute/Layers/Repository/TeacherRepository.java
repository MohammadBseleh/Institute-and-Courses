package com.WebSer.institute.Layers.Repository;

import com.WebSer.institute.Layers.domains.Teacher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

@Repository
public class TeacherRepository {
    private JdbcTemplate jdbcTemplate;
    RowMapper<Teacher> rowMapper;
    public TeacherRepository(JdbcTemplate jdbcTemplate,RowMapper<Teacher> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    public Teacher getTeacher(Long id)
    {
        try{
            Teacher teacher = jdbcTemplate.queryForObject("select * from teachers where id =?",rowMapper , id);
            return teacher;
        }catch (EmptyResultDataAccessException e)
        {
            return null;
        }

    }
    public Teacher createTeacher(Teacher teacher)
    {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO public.teachers(\n" +
                        "\tname, working_hours, full_time, course)\n" +
                        "\tVALUES ( ?, ?, ?, ?);", new String[]{"id"} );
                preparedStatement.setString(1,teacher.getName());
                preparedStatement.setInt(2,teacher.getWorkingHours());
                preparedStatement.setBoolean(3,teacher.isFullTime());
                preparedStatement.setString(4,teacher.getCourse());
                return preparedStatement;
            }
        },keyHolder);

        long generatedKey = keyHolder.getKey().intValue();
        return getTeacher(generatedKey);
    }
    public void deleteTeachers(long id)
    {
        jdbcTemplate.update("DELETE FROM public.teachers\n" +
                "\tWHERE id = ?" , id);
    }
    public Teacher updateTeacher(long id,Teacher teacher)
    {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement("UPDATE public.teachers\n" +
                        "\tSET name=?, working_hours=?, full_time=?, course=?\n" +
                        "\tWHERE id = ?" );
                preparedStatement.setString(1,teacher.getName());
                preparedStatement.setInt(2,teacher.getWorkingHours());
                preparedStatement.setBoolean(3,teacher.isFullTime());
                preparedStatement.setString(4,teacher.getCourse());
                return preparedStatement;

            }
        });
        return getTeacher(id);
    }

}
