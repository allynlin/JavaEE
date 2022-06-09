package com.cshbxy.controller;

import com.cshbxy.pojo.Student;
import com.cshbxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

  @RequestMapping("/addStudent")
  @ResponseBody
  public int addStudent(HttpServletResponse response, Student student) {
    System.out.println(student);
    // 处理中文乱码
    response.setCharacterEncoding("utf-8");
    response.setHeader("content-type", "text/html;charset=utf-8");
    return bean.addStudent(student);
  }

  @RequestMapping("/addPhoto")
  @ResponseBody
  public String addPhoto(MultipartFile pimage, HttpServletResponse response) throws IOException {
    System.out.println(pimage);
    // 处理中文乱码
    response.setCharacterEncoding("utf-8");
    response.setHeader("content-type", "text/html;charset=utf-8");
    if (!pimage.isEmpty()) {
      // 重命名文件
      String fileName = UUID.randomUUID().toString();
      // 获取文件后缀名
      String suffixName =
          pimage.getOriginalFilename().substring(pimage.getOriginalFilename().lastIndexOf("."));
      // 拼接新文件名
      fileName = fileName + suffixName;
      System.out.println(fileName);
      // 保存上传的文件
      pimage.transferTo(
          new File("D:\\Java EE\\StudentManagement\\src\\main\\webapp\\images\\" + fileName));
      System.out.println("文件上传成功");
      return fileName;
    }
    return "failed";
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
