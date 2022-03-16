import com.cshbxy.mapper.CustomerMapper;
import com.cshbxy.pojo.Customer;
import com.cshbxy.untils.MyTool;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestCustomerMapper {
    @Test
    public void testIf() throws IOException {
        //第一大步，创建会话对象sqlSession
//        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession= MyTool.getSqlSession(); //true：关闭时自动提交事务
        //第二大步，通过会话对象的getMapper()方法实现接口CustomerMapper，并获取该对象
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers=mapper.selectByNameAndJobs_if(new Customer());
        for (Customer customer:customers){
            System.out.println(customer);
        }
        //第三大步，完成测试（此处自己针对实现的方法进行测试）

        /*
         第四大步，关闭会话对象。如果是增、删、修改操作，关闭之前还要提交事务。语句如下：
         sqlSession.commit();
         */
        sqlSession.close();
    }
}
