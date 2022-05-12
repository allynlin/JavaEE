package com.cshbxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @RequestMapping("/getProducts")
    public void getProducts(@RequestParam("proId") List<String> proId) {
        for (String id : proId) {
            System.out.println("获取到了商品id：" + id);
        }
    }
}
