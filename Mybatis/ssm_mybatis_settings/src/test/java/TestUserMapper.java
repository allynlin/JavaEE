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
        for (User user:users){
            System.out.println(user);
        }
        System.out.println("====================================");
        User user = mapper.selectById(2);
        System.out.println(user);
//        关闭会话对象
        sqlSession.close();
    }
}
