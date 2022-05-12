package com.cshbxy.controller;

import com.cshbxy.pojo.Order;
import com.cshbxy.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @RequestMapping("/showOrders")
    public void showOrders(User user) {
        List<Order> orders = user.getOrders();
        List<String> addressList = user.getAddress();
        System.out.println("您的订单如下：");
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            String address = addressList.get(i);
            System.out.println("订单号：" + order.getOrderId() + "，地址：" + address);
        }

    }
}
