package com.cshbxy.dao;

import com.cshbxy.pojo.Orders;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersMapper {
    @Select("select * from mybatis.tb_orders where user_id=#{id}")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "number", property = "number")
    })
    List<Orders> selectOrdersByUserId(int user_id);

    @Select("select * from mybatis.tb_orders where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "number", property = "number"),
            @Result(column = "id", property = "productList",
                    many = @Many(select =
                            "com.cshbxy.dao.ProductMapper.selectProductByOrdersId"))})
    Orders selectOrdersById(int id);
}
