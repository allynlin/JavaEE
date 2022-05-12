package com.cshbxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ParamsController {
    @RequestMapping(value = "/id", params = {"id=1"})
    public void displayID(String id) {
        System.out.println("id:" + id);
    }
}
