package com.cshbxy.controller;

import com.cshbxy.pojo.Dog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class DogController {
    /**
     * 普通字符串回写
     * 利用处理器的形参HttpServletResponse实现回写
     */
    @RequestMapping("/hello")
    public void hello(HttpServletResponse response){
        try {
            //处理中文乱码
            response.setCharacterEncoding("utf-8");
            response.setHeader("content-type","text/html;charset=utf-8");
            //回写字符串
            PrintWriter writer = response.getWriter();
            writer.println("这是我的回写字符串...<br/>");
            writer.println("我是长沙环保应用2131班学生。<br/>");
            writer.println("我爱我家、我爱我的学校、我爱我的国家！<br/>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/inputInfo")
    public void inputInfo(HttpServletResponse response){
        try {
            //处理中文乱码
            response.setCharacterEncoding("utf-8");
            response.setHeader("content-type","text/html;charset=utf-8");
            //回写字符串
            PrintWriter writer = response.getWriter();
            writer.println("<div style=\"border:1px solid black;padding:20px;margin:0px 100px\">");
            writer.println("想说的话：<input type=\"text\"/><br/>");
            writer.println("<input type=\"button\" value=\"提交\"/ style=\"margin-top:5px\">");
            writer.println("</div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/jsonInfo")
    public void jsonInfo(HttpServletResponse response){
        try {
            //处理中文乱码
            response.setCharacterEncoding("utf-8");
            response.setHeader("content-type","text/html;charset=utf-8");
            //回写字符串
            ObjectMapper mapper = new ObjectMapper();
            Dog dog = new Dog();
            dog.setBrand("小黑");
            dog.setAge(2);
            String json = mapper.writeValueAsString(dog);
            PrintWriter writer = response.getWriter();
            writer.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
