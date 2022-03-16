package com.cshbxy.mapper;

import com.cshbxy.pojo.Employee;

public interface EmployeeMapper {
    //    按id查询User数据表记录
    Employee selectById(int id);

    //    添加记录
    int add(Employee employee);

    //    按id修改记录
    int update(Employee employee);

    //    按id删除记录
    int deleteById(int id);
}
