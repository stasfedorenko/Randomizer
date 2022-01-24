package com.random.service;

import com.random.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudent(int id);

    void deleteStudent(int id);

    void saveStudent(Student student);
}
