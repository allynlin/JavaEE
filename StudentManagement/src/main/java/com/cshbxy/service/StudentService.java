package com.cshbxy.service;

import com.cshbxy.pojo.Student;

import java.util.List;

public interface StudentService {

  public List<Student> findStudentsByName(String username);

  public int addStudent(Student student);

  public int updateStudent(Student student);

  public int deleteStudent(int id);
}
