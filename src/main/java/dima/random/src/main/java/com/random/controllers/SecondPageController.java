package com.random.controllers;

import com.random.entity.Student;
import com.random.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SecondPageController {

    StudentService studentService;

    @Autowired
    public SecondPageController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String mainPage(Model model) {
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("allStudents3", allStudents);
        return "studentsOnLesson";
    }
}
