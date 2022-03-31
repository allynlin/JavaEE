package com.cshbxy.dao;

import com.cshbxy.pojo.Users;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UsersMapper {
    @Select("select * from mybatis.tb_user where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "address", property = "address"),
            @Result(column = "id", property = "ordersList",
                    many = @Many(select = "com.cshbxy.dao.OrdersMapper.selectOrdersByUserId"))
    })
    Users selectUserById(int id);
}
