package com.cshbxy.service;

import com.cshbxy.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentService {

  @Select("select * from studentmanagement.student where username like concat('%',#{username},'%')")
  public List<Student> findStudentsByName(String username);

  public int addStudent(Student student);

  public int updateStudent(Student student);

  public int deleteStudent(int id);
}
