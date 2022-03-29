import com.cshbxy.pojo.Book;
import com.cshbxy.pojo.Orders;
import com.cshbxy.pojo.Person;
import com.cshbxy.pojo.Users;
import com.cshbxy.untils.MyBatisUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
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

    @Test
    public void findPersonByIdTest2() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //使用MyBtis嵌套查询的方式查询id为1的人的信息
        Person person = session.selectOne("com.cshbxy.mapper.PersonMapper.findPersonById2", 1);
        //输出查询结果信息
        System.out.println(person);
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findUserTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //查询id为1的人的信息
        Users users = session.selectOne("com.cshbxy.mapper.UsersMapper.findUserWithOrders", 1);
        //输出查询结果信息
        System.out.println(users);
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findOrdersTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //查询id为1的人的信息
        Orders orders = session.selectOne("com.cshbxy.mapper.OrdersMapper.findOrdersWithProduct", 1);
        //输出查询结果信息
        System.out.println(orders);
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findOrdersTest2() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //查询id为1的人的信息
        Orders orders = session.selectOne("com.cshbxy.mapper.OrdersMapper.findOrdersWithProduct2", 1);
        //输出查询结果信息
        System.out.println(orders);
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findBookByIdTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //查询id为1的人的信息
        Book book1 = session.selectOne("com.cshbxy.mapper.BookMapper.findBookById", 1);
        //输出查询结果信息
        System.out.println(book1.toString());
        //查询id为1的人的信息
        Book book2 = session.selectOne("com.cshbxy.mapper.BookMapper.findBookById", 1);
        //输出查询结果信息
        System.out.println(book2.toString());
        //关闭SqlSession
        session.close();
    }
}
