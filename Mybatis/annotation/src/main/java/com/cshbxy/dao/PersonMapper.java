package com.cshbxy.dao;

import com.cshbxy.pojo.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {
    @Select("select * from mybatis.tb_person where id=#{id}")
    @Results({@Result(column = "card_id", property = "card", one = @One(select = "com.cshbxy.dao.IdCardMapper.selectIdCardById"))})
    Person selectPersonById(int id);
}
