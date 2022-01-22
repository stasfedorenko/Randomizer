package com.random.service;


import com.random.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class StudentServiceImpl implements StudentService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = jdbcTemplate.query("SELECT * FROM students", (ResultSet rs, int rowNum) ->
                {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setSurname(rs.getString("surname"));
                    return student;
                });
        return new ArrayList<>(students);
    }

    @Override
    public Student getStudent(int id) {
        Student student = jdbcTemplate.queryForObject("SELECT * FROM students WHERE id = ?",
                (ResultSet rs, int rowNum) ->
        {
            Student student1 = new Student();
            student1.setId(rs.getInt("id"));
            student1.setName(rs.getString("name"));
            student1.setSurname(rs.getString("surname"));
            return student1;
        });
        return student;
    }
}
