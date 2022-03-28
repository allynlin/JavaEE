import com.cshbxy.pojo.Student;
import com.cshbxy.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class findStudentByNameAndMajor {
    @Test
    public static void main(String[] args){
        SqlSession session= MyBatisUtils.getSession();
        Student student=new Student();
        student.setName("张三");
        student.setMajor("英语");
        List<Student> students=session.selectList("com.cshbxy.mapper.StudentMapper.findStudentByNameAndMajor",student);
        for (Student student2:students){
            System.out.println(student2);
        }
        session.close();
    }
}
