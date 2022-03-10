package com.cshbxy.mapper;

import com.cshbxy.pojo.User;

//定义数据表的操作
public interface UserMapper {

    //    按id查询User数据表记录
    User selectById(int uid);

    //    添加记录
    int add(User user);

    //    按id修改记录
    int update(User user);

    //    按id删除记录
    int deleteById(int id);
}