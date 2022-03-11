package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private StudentDao studentDao;

  @Autowired
  public StudentService(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public List<Student> getAllStudents() {
    return studentDao.selectAllStudents();

  }
}