package com.cshbxy.dao;

import com.cshbxy.pojo.IClass;
import com.cshbxy.pojo.IStudent;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IClassMapper {
    @Select("select * from mybatis.c_class where id=#{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "classname", property = "classname"),
            @Result(column = "id", property = "studentList",
                    many= @Many(select =
                    "com.cshbxy.dao.IStudentMapper.selectStudentByCid"))})
    IClass selectClassById(int id);
}
