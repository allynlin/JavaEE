package com.cshbxy.mapper;

import com.cshbxy.pojo.User;

import java.util.List;

//定义数据表的操作
public interface UserMapper {
    //    查询User数据表所有记录
    List<User> selectAll();

    //    按id查询User数据表记录
    User selectById(int uid);

    //    按姓名模糊查询
    List<User> selectByName(String uname);

    //    按id及姓名查询
    List<User> selectByIdName(int uid, String uname);

    //    按id、姓名、年龄查询
    List<User> selectByAll(User user);

    //    添加记录
    int add(User user);

    //    按id修改记录
    int update(User user);

    //    按id删除记录
    int deleteById(int id);
}