package com.cshbxy.controller;

import com.cshbxy.pojo.Student;
import com.cshbxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Allyn
 */
@Controller
@RequestMapping("/student")
public class StudentController {
  @Autowired private StudentService studentService;
  @Resource private StudentService bean;

  @RequestMapping("/findStudentsByName")
  @ResponseBody
  public List<Student> findStudentsByName(HttpServletResponse response, String username) {
    // 处理中文乱码
    response.setCharacterEncoding("utf-8");
    response.setHeader("content-type", "text/html;charset=utf-8");
    return bean.findStudentsByName(username);
  }

  @RequestMapping("/findStudentById")
  @ResponseBody
  public Student findStudentById(HttpServletResponse response, int id) {
    // 处理中文乱码
    response.setCharacterEncoding("utf-8");
    response.setHeader("content-type", "text/html;charset=utf-8");
    return bean.findStudentById(id);
  }

  @RequestMapping("/addStudent")
  @ResponseBody
  public String addStudent(HttpServletResponse response, Student student) {
    // 处理中文乱码
    response.setCharacterEncoding("utf-8");
    response.setHeader("content-type", "text/html;charset=utf-8");
    return bean.addStudent(student);
  }

  @RequestMapping("/updateStudent")
  @ResponseBody
  public int updateStudent(HttpServletResponse response, Student student) {
    // 处理中文乱码
    response.setCharacterEncoding("utf-8");
    response.setHeader("content-type", "text/html;charset=utf-8");
    int result = bean.updateStudent(student);
    System.out.println(result);
    return result;
  }

  @RequestMapping("/deleteStudent")
  @ResponseBody
  public int deleteStudent(HttpServletResponse response, int id) {
    // 处理中文乱码
    response.setCharacterEncoding("utf-8");
    response.setHeader("content-type", "text/html;charset=utf-8");
    int result = bean.deleteStudent(id);
    System.out.println(result);
    return result;
  }
}
