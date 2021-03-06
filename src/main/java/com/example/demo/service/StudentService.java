package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import java.util.List;
import java.util.UUID;
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

  public int addStudent(Student student) {
    return studentDao.insertStudent(student);
  }

  public int updateStudent(Student student) {
    return studentDao.updateStudent(student);
  }

  public int deleteStudentById(UUID id) {
    return studentDao.deleteStudentById(id);
  }
}
