package com.cshbxy.dao;

import com.cshbxy.pojo.Worker;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.apache.ibatis.annotations.*;

public interface WorkerMapper {
    @Select("select * from mybatis.tb_worker where id=#{id}")
    Worker selectWorker(int id);

    @Insert("insert into mybatis.tb_worker(name,age,sex,worker_id) values(#{name},#{age},#{sex},#{worker_id})")
    int insertWorker(Worker worker);

    @Update("update mybatis.tb_worker set name=#{name},age=#{age} where id=#{id}")
    int updateWorker(Worker worker);

    @Delete("delete from mybatis.tb_worker where id=#{id}")
    int deleteWorker(int id);

    @Select("select * from mybatis.tb_worker where id=#{param01} and name=#{param02}")
    Worker selectWorkerByIdAndName(@Param("param01") int id,@Param("param02") String name);
}
