package com.cshbxy.mapper;

import com.cshbxy.pojo.User;

import java.util.List;

//定义数据表的操作
public interface UserMapper {
    //    查询User数据表所有记录
    List<User> selectAll();

    //    按id查询User数据表记录
    User selectById(int uid);

    //    向User数据表插入记录
    int add(User user);

    //    按id删除记录
    int deleteById(int id);
}