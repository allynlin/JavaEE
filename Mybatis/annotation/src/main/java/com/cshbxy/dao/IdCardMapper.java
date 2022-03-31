package com.cshbxy.dao;

import com.cshbxy.pojo.IdCard;
import org.apache.ibatis.annotations.Select;

public interface IdCardMapper {
    @Select("select * from mybatis.tb_idcard where id=#{id}")
    IdCard selectIdCardById(int id);
}
