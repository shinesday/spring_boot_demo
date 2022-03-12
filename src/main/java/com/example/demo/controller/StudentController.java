package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {

  private StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }

  @PostMapping
  public String addStudent(@RequestBody  Student student) {
    studentService.addStudent(student);
    return "Added Student!";
  }

  @PostMapping
  public String updateStudent(@RequestBody  Student student) {
    studentService.updateStudent(student);
    return "Updated Student!";
  }

  @DeleteMapping(path = "{id}")
  public String deleteStudentById(@PathVariable("id") UUID id) {
    studentService.deleteStudentById(id);
    return "Deleted Student!";
  }

}
