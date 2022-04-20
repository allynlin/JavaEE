package com.cshbxy.student;

import java.util.List;

public interface StudentDao {
    //添加学生信息
    public int addStudent(Student student);

    //删除学生信息
    public int deleteStudent(int id);

    //修改学生信息
    public int updateStudent(Student student);

    //查询单个学生信息
    public Student findStudentById(int id);

    //查询所有学生信息
    public List<Student> findAllStudent();
}
