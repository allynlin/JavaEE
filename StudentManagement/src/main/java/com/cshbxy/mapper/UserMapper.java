package com.cshbxy.mapper;

import com.cshbxy.pojo.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from user where username=#{username} and password=#{password}")
    @Results(id="userMap",value={
            @Result(id=true,column="id",property="id"),
            @Result(column="username",property="username"),
            @Result(column="password",property="password")
    })
    User login(User user);
}
