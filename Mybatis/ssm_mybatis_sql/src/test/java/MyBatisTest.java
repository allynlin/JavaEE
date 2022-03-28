import com.cshbxy.pojo.Customer;
import com.cshbxy.untils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
    @Test
    public void findCustomerByNameAndJobsTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建Customer对象，封装需要组合查询的条件
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        //执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.cshbxy.mapper.CustomerMapper.findCustomerByNameAndJobs", customer);
        //输出查询结果信息
        for (Customer customer1 : customers) {
            System.out.println(customer1);
        }
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findCustomerByNameOrJobsTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建Customer对象，封装需要组合查询的条件
        Customer customer = new Customer();
        customer.setUsername("tom");
        customer.setJobs("teacher");
        //执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.cshbxy.mapper.CustomerMapper.findCustomerByNameOrJobs", customer);
        //输出查询结果信息
        for (Customer customer2 : customers) {
            System.out.println(customer2);
        }
        //关闭SqlSession
        session.close();
    }

    @Test
    public void updateCustomerBySetTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建Customer对象，封装需要组合查询的条件
        Customer customer = new Customer();
        customer.setId(3);
        customer.setPhone("13311111235");
        //执行SqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = session.update("com.cshbxy.mapper.CustomerMapper.updateCustomerBySet", customer);
        //通过返回结果判断更新操作是否执行成功
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据");
        } else {
            System.out.println("执行修改操作失败");
        }
        //提交事务
        session.commit();
        //关闭SqlSession
        session.close();
    }

    @Test
    public void updateCustomerByTrimTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建Customer对象，封装需要组合查询的条件
        Customer customer = new Customer();
        customer.setId(3);
        customer.setUsername("tom");
        //执行SqlSession的更新方法，返回的是SQL语句影响的行数
        int rows = session.update("com.cshbxy.mapper.CustomerMapper.updateCustomerByTrim", customer);
        //通过返回结果判断更新操作是否执行成功
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据");
        } else {
            System.out.println("执行修改操作失败");
        }
        //提交事务
        session.commit();
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findByArrayTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建数组，封装查询id
        Integer[] roleIds = {2, 3};
        //执行SqlSession的查询方法，返回结果集
        List<Customer> customers = session.selectList("com.cshbxy.mapper.CustomerMapper.findByArray", roleIds);
        //输出查询结果信息
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        //关闭SqlSession
        session.close();
    }
}
