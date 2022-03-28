import com.cshbxy.pojo.Student;
import com.cshbxy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class findByList {
    @Test
    public static void main(String[] args) {
        SqlSession session= MyBatisUtils.getSession();
        List<Integer> ids=new ArrayList<Integer>();
        for (int i=1;i<5;i++){
            ids.add(i);
        }
        List<Student> students=session.selectList("com.cshbxy.mapper.StudentMapper.findByList",ids);
        for (Student student:students){
            System.out.println(student);
        }
        session.close();
    }
}
