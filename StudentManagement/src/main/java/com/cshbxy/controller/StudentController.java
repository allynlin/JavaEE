package com.cshbxy.controller;

import com.cshbxy.pojo.Student;
import com.cshbxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Allyn
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
//    @RequestMapping("/findAllStudents")
//    public ModelAndView findAllStudents(){
//        int pageNum=1;
//        int pageSize=5;
//        PageResult pageResult=studentService.findAllStudents(pageNum,pageSize);
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("student_list");
//        modelAndView.addObject("pageResult",pageResult);
//        return modelAndView;
//    }

//    @RequestMapping("/findStudentsByName")
//    public ModelAndView findStudentsByName(HttpServletRequest request){
////        int pageNum=1;
////        int pageSize=5;
//        // 接收前端传过来的参数
//        String username=request.getParameter("username");
//        PageResult pageResult=studentService.findStudentsByName(username);
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("findStudentsByName");
//        modelAndView.addObject("pageResult",pageResult);
//        return modelAndView;
//    }
@Resource
private StudentService bean;

    @RequestMapping("/findStudentsByName")
    @ResponseBody
    public List<Student> findStudentsByName(HttpServletResponse response, String username) {
//        request.setCharacterEncoding("utf-8");
//        String bookName = request.getParameter("bookName");
//        try {
        //处理中文乱码
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        //回写字符串
//            ApplicationContext context = new ClassPathXmlApplicationContext("spring-mvc.xml");
//            BookDao bean = context.getBean(BookDao.class);
//            System.out.println("bookName:"+bookName);
        return bean.findStudentsByName(username);
//            String json = new ObjectMapper().writeValueAsString(books);
//            PrintWriter writer = response.getWriter();
//            writer.println(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @RequestMapping("/findStudentById")
    @ResponseBody
    public Student findStudentById(HttpServletResponse response, int id) {
        //处理中文乱码
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        return bean.findStudentById(id);
    }

    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(HttpServletResponse response, Student student, HttpServletRequest request) {
        //处理中文乱码
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
//        request.setAttribute("msg","success");
        return bean.addStudent(student);
    }

    @RequestMapping("/updateStudent")
    @ResponseBody
    public int updateStudent(HttpServletResponse response, Student student, HttpServletRequest request) {
        //处理中文乱码
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
//        request.setAttribute("msg","success");
        int result=bean.updateStudent(student);
        System.out.println(result);
//        request.setAttribute("msg",result);
        return result;
    }

    @RequestMapping("/deleteStudent")
    @ResponseBody
    public int deleteStudent(HttpServletResponse response, int id, HttpServletRequest request) {
        //处理中文乱码
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
//        System.out.println(id);
        int result=bean.deleteStudent(id);
        System.out.println(result);
        return result;
    }
}
