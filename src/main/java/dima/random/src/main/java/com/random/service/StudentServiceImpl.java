package com.random.service;


import com.random.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final JdbcTemplate jdbcTemplate;

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
                    student.setIsPresent(rs.getString("isPresent"));
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

    @Override
    public void deleteStudent(int id) {
        jdbcTemplate.update("DELETE FROM students WHERE id = ?", id);
    }

    @Override
    public void saveStudent(Student student) {
        jdbcTemplate.update("INSERT INTO students values (?,?, ?, ?)",student.getId(), student.getName(), student.getSurname(), student.getIsPresent());
    }


}
