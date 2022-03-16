import com.cshbxy.mapper.EmployeeMapper;
import com.cshbxy.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestEmployeeMapper {
    @Test
    public void test() throws IOException {
//        获取核心配置文件流
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        构建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        构建SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        利用SqlSession对象生成一个已实现的接口对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        按ID查询
        Employee employee = mapper.selectById(2);
        System.out.println(employee);
//        关闭会话对象
        sqlSession.close();
    }

    @Test
    public void test02() throws IOException {
        //        获取核心配置文件流
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        构建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        构建SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        利用SqlSession对象生成一个已实现的接口对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(5);
        employee.setName("李好好");
        employee.setAge(22);
        employee.setPosition("经理");
        int n = mapper.add(employee);
        if (n != 0) {
            System.out.println("成功");
        }
        sqlSession.commit();//提交事务
        sqlSession.close();
    }

    @Test
    public void test03() throws IOException {
        //        获取核心配置文件流
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        构建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        构建SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        利用SqlSession对象生成一个已实现的接口对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(5);
        employee.setAge(30);
        employee.setName("刘好好");
        employee.setPosition("员工");
        int n = mapper.update(employee);
        if (n != 0) {
            System.out.println("成功");
        }
        sqlSession.commit();//提交事务
        sqlSession.close();
    }

    @Test
    public void test04() throws IOException {
        //        获取核心配置文件流
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        构建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        构建SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        利用SqlSession对象生成一个已实现的接口对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        User user = new User();
//        user.setUid(5);
//        user.setUage(30);
//        user.setUname("刘好好");
        int n = mapper.deleteById(5);
        if (n != 0) {
            System.out.println("成功");
        }
        sqlSession.commit();//提交事务
        sqlSession.close();
    }

    @Test
    public void test05() throws IOException {
//        获取核心配置文件流
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        构建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        构建SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        利用SqlSession对象生成一个已实现的接口对象
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setName("李好好");
        employee.setAge(22);
        employee.setPosition("经理");
        int n = mapper.autoadd(employee);
        if (n > 0) {
            System.out.println("成功");
        }
        sqlSession.commit();//提交事务
        sqlSession.close();
    }
}
