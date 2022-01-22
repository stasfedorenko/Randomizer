package com.random.controllers;

import com.random.entity.Student;
import com.random.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/random")
public class MainPageController {


    StudentService studentService;

    @Autowired
    public MainPageController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("allStudents", allStudents);
        return "index";
    }
    @GetMapping("/student/{id}")
    public String getStudent(@PathVariable int id, Model model){
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "redirect:/random/main";
    }
}
