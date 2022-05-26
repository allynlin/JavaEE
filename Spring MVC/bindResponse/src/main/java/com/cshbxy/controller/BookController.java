package com.cshbxy.controller;

import com.cshbxy.pojo.Book;
import com.cshbxy.pojo.BookDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class BookController {
    @Resource
    private BookDao bean;

    @RequestMapping("/findBooksByName")
    @ResponseBody
    public List<Book> findBooksByName(HttpServletResponse response, String bookName) {
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
        return bean.findBooksByName(bookName);
//            String json = new ObjectMapper().writeValueAsString(books);
//            PrintWriter writer = response.getWriter();
//            writer.println(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
