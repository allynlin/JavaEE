package com.cshbxy.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/method")
public class MethodController {
    @RequestMapping(method = RequestMethod.GET)
    public void get(){
        System.out.println("执行get请求...");
    }
    @RequestMapping(method = RequestMethod.POST)
    public void post(){
        System.out.println("执行post请求...");
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(){
        System.out.println("执行delete请求...");
    }
    @RequestMapping(method = RequestMethod.PUT)
    public void put(){
        System.out.println("执行put请求...");
    }
}