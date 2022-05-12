package com.cshbxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class login {
    @RequestMapping(value = "/getlogin/{username}/{password}")
    public void getLogin(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
    }
}
