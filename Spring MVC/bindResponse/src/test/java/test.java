import com.cshbxy.pojo.User;
import com.cshbxy.pojo.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao bean = context.getBean(UserDao.class);
        User user1=bean.findUserByUserNameAndPassword("Tom", "123456");
        System.out.println(user1);
    }
}
