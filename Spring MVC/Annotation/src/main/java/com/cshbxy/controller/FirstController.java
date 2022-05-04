package com.cshbxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {
    @RequestMapping("/firstController")
    public String sayHello(){
        System.out.println("Hello World");
        return "success";
    }

    @RequestMapping("/page01")
    public String toPage01() {
        return "jsp/page01";
    }

    /**
     * toPage02():显示page02.jsp。映射路径为/page02
     */
    @RequestMapping("/page02")
    public String toPage02() {
        return "jsp/page02";
    }

    /**
     * toEdit():显示page01.jsp。映射路径为/user/edit
     */
    @RequestMapping("/user/edit")
    public String toEdit() {
        return "user/editUser";
    }
}
