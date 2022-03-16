package com.cshbxy.mapper;

import com.cshbxy.pojo.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    /*完成if元素实验。实验要求：按姓名和职业查询，如果查询值为空或空串，则不纳入条件*/
    List<Customer> selectByNameAndJobs_if(Customer customer);

    /*完成choose when otherwise元素实验。实验要求：仅按姓名或职业中的某个给定条件查询(查询值为空或空串，不纳入条件)，如果姓名、职业均未给定查询值，则查询手机号非空用户*/
    List<Customer> selectByNameOrJobs_choose(Customer customer);

    /*完成where实验。实验要求：按姓名或职业查询，如果查询值为空或空串，则不纳入条件*/
    List<Customer> selectByNameAndJobs_where(Customer customer);

    /*完成trim实验。实验要求：按姓名或职业查询，如果查询值为空或空串，则不纳入条件*/
    List<Customer> selectByNameAndJobs_trim(Customer customer);

    /*完成set实验。实验要求：按id更新记录，只修改给定属性值不为空和空串的字段*/
    int updateById_set(Customer customer);

    /*完成trim实验。实验要求：按id更新记录，只修改给定属性值不为空和空串的字段*/
    int updateById_trim(Customer customer);

    /*完成foreach遍历数组实验。实验要求：查询id值为多个指定值的记录。多个id值通过数组传入*/
    List<Customer> selectById_Arrays(int[] ids);

    /*完成foreach遍历数组实验。实验要求：查询id值为多个指定值的记录。多个id值通过List传入*/
    List<Customer> selectById_List(List<Integer> ids);

    /*完成foreach遍历Map实验。实验要求：仅显示id值为数组元素值的记录。多个id值通过Map传入*/
    List<Customer> selectById_Map(Map ids);

    /*完成参数为Map的实验。实验要求：查询记录，查询字段及值由Map给定(即：查询条件有不确定性，由用户给出)。
     * 此种情况下，Map传入多参数时要求用户调用给定实参时，实参的键值必须是表字段名，否则会出错。*/
    List<Customer> selectByUnConditon(Map customer);
}
