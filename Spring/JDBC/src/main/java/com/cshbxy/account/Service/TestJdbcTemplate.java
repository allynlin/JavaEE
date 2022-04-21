package com.cshbxy.account.Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbcTemplate {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbc = context.getBean(JdbcTemplate.class);
        String sql = "create table account(" +
                "id int primary key auto_increment," +
                "username varchar(50)," +
                "balance double" +
                ")";
        jdbc.execute(sql);
        System.out.println("account数据表创建成功！");
    }
}
