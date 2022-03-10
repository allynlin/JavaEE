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
        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("====================================");
        User user = mapper.selectById(3);
        System.out.println(user);
        System.out.println("====================================");
        users = mapper.selectByIdName(2, "李四");
        for (User user1 : users) {
            System.out.println(user1);
        }
        System.out.println("====================================");
        users = mapper.selectByName("李");
        for (User user2 : users) {
            System.out.println(user2);
        }
        System.out.println("====================================");
        User user00 = new User();
        user00.setUid(3);
        user00.setUname("张三");
        user00.setUage(18);
        users = mapper.selectByAll(user00);
        for (User users1 : users) {
            System.out.println(users1);
        }
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
        user1.setUid(5);
        user1.setUname("李好好");
        user1.setUage(22);
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
        user.setUid(5);
        user.setUage(30);
        user.setUname("刘好好");
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
