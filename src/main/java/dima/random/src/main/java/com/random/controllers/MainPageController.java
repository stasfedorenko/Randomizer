package com.random.controllers;

import com.random.entity.Student;
import com.random.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/random")
public class MainPageController {
    private final Logger logger = Logger.getLogger(MainPageController.class);

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

    @GetMapping("/students")
    public String updateStudents(){
        return "studentsOnLesson";
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);
        return "redirect:/random/main";
    }
    @PostMapping("/addNewStudent")
    public String addNewStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "addStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){

        studentService.saveStudent(student);

        return "redirect:/random/main";
    }
}
