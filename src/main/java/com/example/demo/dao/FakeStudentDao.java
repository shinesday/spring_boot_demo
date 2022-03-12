package com.example.demo.dao;

import com.example.demo.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

  @Override
  public Optional<Student> selectStudentById(UUID id) {
    for (Student s: dataBase) {
      if (s.getId().equals(id)) {
        return Optional.of(s);
      }
    }
    return Optional.empty();
  }

  @Override
  public int updateStudent(Student student) {
    Optional<Student> optionalStudent = selectStudentById(student.getId());
    if (!optionalStudent.isPresent()) {
      return -1;
    }
    int indexToUpdate = -1;
    for (int i = 0; i < dataBase.size(); i++) {
      if (student.getId().equals(dataBase.get(i).getId())) {
        indexToUpdate = i;
        break;
      }

    }
    dataBase.set(indexToUpdate, student);
    return 1;
  }

  @Override
  public int deleteStudentById(UUID id) {
    Optional<Student> optionalStudent = selectStudentById(id);
    if (!optionalStudent.isPresent()) {
      return -1;
    }
    dataBase.remove(optionalStudent.get());
    return 1;
  }
}
