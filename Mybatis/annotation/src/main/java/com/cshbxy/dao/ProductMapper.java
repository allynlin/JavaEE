package com.cshbxy.dao;

import com.cshbxy.pojo.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    @Select("select * from mybatis.tb_product where id in(select productb_id from mybatis.tb_ordersitem where orders_id=#{id})")
    List<Product> selectProductByOrdersId(int orders_id);
}
