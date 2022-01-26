package com.random.controllers;

import com.random.entity.Student;
import com.random.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/random/main";
    }

    @RequestMapping("/addNewStudent")
    public String addNewStudent() {
        return "addStudent";
    }

    @PostMapping(value = "/saveStudent")
    public String saveStudent(Student student) {
        studentService.saveStudent(student);
        return "redirect:/random/main";
    }
}
