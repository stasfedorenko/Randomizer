package com.random.controllers;

import com.random.DAO.StudentDAO;
import com.random.entity.Student;
import com.random.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/random")
public class SecondPageController {

    StudentService studentService;
    StudentDAO studentDAO;


    @Autowired
    public SecondPageController(StudentService studentService, StudentDAO studentDAO) {
        this.studentService = studentService;
        this.studentDAO = studentDAO;

    }

    @GetMapping("/studentsLesson")
    public String mainPage(Model model) {
//        List<Student> allStudents = studentService.getAllStudents();
//        model.addAttribute("allStudents3", allStudents);
        model.addAttribute("students", studentService.getStudent(1));
        return "studentsOnLesson";
    }

    @GetMapping("/student")
    public String findStudent(Model model){
       // studentService.getStudent(1);
       model.addAttribute("students", studentService.getStudent(1));
        return "redirect:/random/studentsLesson";
    }
}
