package com.cshbxy.controller;

import com.cshbxy.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/getProduct")
    public void getProduct(@RequestBody Product product) {
        String proId = product.getProId();
        String proName = product.getProName();
        System.out.println("获取到了Id为" + proId + "名称为" + proName + "的商品");
    }
    @RequestMapping("/getProductList")
    public void getProductList(@RequestBody List<Product> products) {
        for (Product product : products) {
            String proId = product.getProId();
            String proName = product.getProName();
            System.out.println("获取到了Id为" + proId + "名称为" +
                    proName + "的商品");
        }
    }
}
