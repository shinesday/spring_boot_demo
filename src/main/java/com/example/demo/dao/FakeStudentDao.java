package com.example.demo.dao;

import com.example.demo.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeStudentDao implements StudentDao{

  private static List<Student> dataBase = new ArrayList<>();

  @Override
  public List<Student> selectAllStudents() {
    return dataBase;
  }

  @Override
  public int insertStudent(Student student) {
    UUID id = UUID.randomUUID();
    dataBase.add(new Student(id, student.getName()));
    return 1;
  }
}
