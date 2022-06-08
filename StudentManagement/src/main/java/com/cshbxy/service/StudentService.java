package com.cshbxy.service;

import com.cshbxy.pojo.Student;

import java.util.List;

public interface StudentService {
//    PageResult findAllStudents(int pageNum, int pageSize);

//    PageResult findStudentsByName(String name);

    public List<Student> findStudentsByName(String username);

    public Student findStudentById(int id);

    public String addStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(int id);
}
