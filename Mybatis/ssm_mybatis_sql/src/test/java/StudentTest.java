import com.cshbxy.pojo.Customer;
import com.cshbxy.pojo.Student;
import com.cshbxy.untils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {
    @Test
    public void findByIdTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建Customer对象，封装需要组合查询的条件
        Student student = new Student();
        student.setId(2);
        //执行SqlSession的查询方法，返回结果集
        List<Student> students = session.selectList("com.cshbxy.mapper.StudentMapper.findById", student);
        //输出查询结果信息
        for (Student student1 : students) {
            System.out.println(student1);
        }
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findStudentByNameOrMajorTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建Customer对象，封装需要组合查询的条件
        Student student = new Student();
//        student.setName("张");
        student.setMajor("计算机");
        //执行SqlSession的查询方法，返回结果集
        List<Student> students = session.selectList("com.cshbxy.mapper.StudentMapper.findStudentByNameOrMajor", student);
        //输出查询结果信息
        for (Student student1 : students) {
            System.out.println(student1);
        }
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findByMajor_ArraysTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建数组，封装查询id
        Integer[] roleIds = {2, 3, 4, 5};
        //执行SqlSession的查询方法，返回结果集
        List<Student> students = session.selectList("com.cshbxy.mapper.StudentMapper.findByMajor_Arrays", roleIds);
        //输出查询结果信息
        for (Student student1 : students) {
            System.out.println(student1);
        }
        //关闭SqlSession
        session.close();
    }

    @Test
    public void findByMajor_ListTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建List集合，封装查询id
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        //执行SqlSession的查询方法，返回结果集
        List<Student> students = session.selectList("com.cshbxy.mapper.StudentMapper.findByMajor_List", ids);
        //输出查询结果信息
        for (Student student1 : students) {
            System.out.println(student1);
        }
        //关闭SqlSession
        session.close();
    }

    @Test
    public void updateByIdTest() {
        //通过工具箱获取SqlSession对象
        SqlSession session = MyBatisUtils.getSession();
        //创建Customer对象，封装需要组合查询的条件
        Student student = new Student();
        student.setId(2);
        student.setName("小小");
        student.setMajor("政治");
        student.setSno(11111);
        int rows = session.update("com.cshbxy.mapper.StudentMapper.updateById", student);
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
}
