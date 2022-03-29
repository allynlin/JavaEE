import com.cshbxy.pojo.Person;
import com.cshbxy.untils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {
    @Test
    public void findPersonByIdTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //使用MyBtis嵌套查询的方式查询id为1的人的信息
        Person person = session.selectOne("com.cshbxy.mapper.PersonMapper.findPersonById", 1);
        //输出查询结果信息
        System.out.println(person);
        //关闭SqlSession
        session.close();
    }
}
