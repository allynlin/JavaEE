package com.cshbxy.dao;

import com.cshbxy.pojo.IStudent;
import com.cshbxy.pojo.Worker;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IStudentMapper {
    @Select("select * from mybatis.s_student where id=#{id}")
    IStudent selectStudent(int id);

    @Update("update mybatis.s_student set name=#{name},age=#{age} where id=#{id}")
    int updateStudent(IStudent student);

    @Select("select * from mybatis.s_student where cid=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "classname",property = "classname")
    })
    List<IStudent> selectStudentByCid(int cid);
}
