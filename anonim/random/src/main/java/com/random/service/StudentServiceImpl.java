package com.random.service;


import com.random.DAO.StudentDAO;
import com.random.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public Student getStudent(int id) {
        Optional<Student> optionalStudent = studentDAO.findById(id);
        return optionalStudent.get();
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentDAO.save(student);

    }
}
