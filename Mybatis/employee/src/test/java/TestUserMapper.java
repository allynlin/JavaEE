import com.cshbxy.mapper.UserMapper;
import com.cshbxy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class TestUserMapper {
    @Test
    public void test() throws IOException {
//        获取核心配置文件流
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        构建会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        构建SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        利用SqlSession对象生成一个已实现的接口对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        按ID查询
//        int min = 1; // 定义随机数的最小值
//        int max = 3; // 定义随机数的最大值
        // 产生一个2~100的数
        int s = 1+(int) (Math.random() * 3);
        System.out.println(s);
        User user = mapper.selectById(s);
        System.out.println(user);
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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = new User();
        user1.setId(5);
        user1.setName("李好好");
        user1.setAge(22);
        user1.setPosition("经理");
        int n = mapper.add(user1);
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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        user.setAge(30);
        user.setName("刘好好");
        user.setPosition("员工");
        int n = mapper.update(user);
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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
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
}
