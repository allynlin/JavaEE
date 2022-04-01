import com.cshbxy.dao.OrdersMapper;
import com.cshbxy.dao.PersonMapper;
import com.cshbxy.dao.UsersMapper;
import com.cshbxy.dao.WorkerMapper;
import com.cshbxy.pojo.Orders;
import com.cshbxy.pojo.Person;
import com.cshbxy.pojo.Users;
import com.cshbxy.pojo.Worker;
import com.cshbxy.untils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyBatisTest {
    @Test
    public void findWorkerByIdTest() {
        //通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        //使用WorkerMapper对象查询id为1的员工信息
        Worker worker = mapper.selectWorker(1);
        System.out.println(worker.toString());
        //关闭SqlSession
        session.close();
    }

    @Test
    public void insertWorkerTest() {
        //通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Worker worker = new Worker();
        worker.setId(4);
        worker.setName("赵六");
        worker.setAge(36);
        worker.setSex("女");
        worker.setWorker_id("1004");
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        int result = mapper.insertWorker(worker);
        if (result > 0)
            System.out.println("成功插入" + result + "条数据");
        else
            System.out.println("插入数据失败");
        System.out.println(worker.toString());
        session.commit();
        //关闭SqlSession
        session.close();
    }

    @Test
    public void updateWorkerTest() {
        //通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        Worker worker = new Worker();
        worker.setId(2);
        worker.setName("赵六");
        worker.setAge(36);
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        int result = mapper.updateWorker(worker);
        if (result > 0)
            System.out.println("成功修改" + result + "条数据");
        else
            System.out.println("修改数据失败");
        System.out.println(worker.toString());
        session.commit();
        //关闭SqlSession
        session.close();
    }

    @Test
    public void deleteWorkerTest() {
        //通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        int result = mapper.deleteWorker(4);
        if (result > 0)
            System.out.println("成功删除" + result + "条数据");
        else
            System.out.println("删除数据失败");
        session.commit();
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findWorkerByIdAndNameTest() {
        //通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        WorkerMapper mapper = session.getMapper(WorkerMapper.class);
        //使用WorkerMapper对象查询id为1并且姓名为张三的员工信息
        Worker worker = mapper.selectWorkerByIdAndName(1, "张三");
        System.out.println(worker.toString());
        //关闭SqlSession
        session.close();
    }

    @Test
    public void selectPersonByIdTest() {
        //通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        //查询id为1的人员信息
        Person person = mapper.selectPersonById(2);
        System.out.println(person);
        //关闭SqlSession
        session.close();
    }

    @Test
    public void selectUserByIdTest() {
        //通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        //查询id为1的人员信息
        Users users = mapper.selectUserById(1);
        System.out.println(users.toString());
        //关闭SqlSession
        session.close();
    }

    @Test
    public void selectOrdersByIdTest() {
        //通过工具类获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        OrdersMapper mapper = session.getMapper(OrdersMapper.class);
        //查询id为1的人员信息
        Orders orders = mapper.selectOrdersById(3);
        System.out.println(orders.toString());
        //关闭SqlSession
        session.close();
    }
}
