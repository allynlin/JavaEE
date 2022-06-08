package com.cshbxy.service;

import com.cshbxy.pojo.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Allyn
 */
@Service
@Transactional
@Repository
public class StudentServiceImpl implements StudentService {

    @Resource
    private JdbcTemplate jdbcTemplate;
//
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> findStudentsByName(String username) {
        if (username == null || username.trim().equals("")) {
            username = "";
        }

//            String sql = "select * from spring.book";
//            List<Book> book = null;
//            try {
//                RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
//                book = jdbcTemplate.query(sql, rowMapper);
//            } catch (DataAccessException e) {
//                return null;
//            }
//            return book

        String sql = "select * from studentmanagement.student where username like ?";
        List<Student> students = null;
        try {
            RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
            students = jdbcTemplate.query(sql, new Object[]{"%" + username + "%"}, rowMapper);
        } catch (DataAccessException e) {
            return null;
        }
        return students;
    }
    // 注入对象
//    @Autowired
//    private StudentMapper studentMapper;
//    @Override
//    public PageResult findAllStudents(int pageNum, int pageSize) {
//        // 设置分页查询的参数，开始分页
//        PageHelper.startPage(pageNum, pageSize);
//        Page<Student> page= studentMapper.findAllStudents();
//        return new PageResult(page.getTotal(),page.getResult());
//    }

//    @Override
//    public PageResult findStudentsByName(String username) {
//        // 设置分页查询的参数，开始分页
//        PageHelper.startPage(1, 5);
//        Page<Student> page= studentMapper.findStudentsByName(username);
//        return new PageResult(page.getTotal(),page.getResult());
//    }

    @Override
    public Student findStudentById(int id) {
        String sql = "select * from studentmanagement.student where id = ?";
        Student student = null;
        try {
            RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
            student = jdbcTemplate.queryForObject(sql, new Object[]{id}, rowMapper);
        } catch (DataAccessException e) {
            return null;
        }
        return student;
    }

    @Override
    public String addStudent(Student student) {
        String sql = "insert into studentmanagement.student(username,age,userclass) values(?,?,?)";
        int result = jdbcTemplate.update(sql, student.getUsername(), student.getAge(), student.getUserclass());
        String res;
        if (result == 1) {
            res = "添加成功,您添加的学生是："+student.getUsername();
//            return student.getId();
        } else {
            res="添加失败";
        }
        return res;
    }

    @Override
    public int updateStudent(Student student) {
        System.out.println("获取到了id为："+student.getId()+"，姓名为:"+student.getUsername()+",年龄为:"+student.getAge()+",班级为:"+student.getUserclass()+"的学生");
        String sql = "update studentmanagement.student set username = ?,age = ?,userclass = ? where id = ?";
        int result = jdbcTemplate.update(sql, student.getUsername(), student.getAge(), student.getUserclass(), student.getId());
        return result;
    }

    @Override
    public int deleteStudent(int id) {
        String sql = "delete from studentmanagement.student where id = ?";
        int result = jdbcTemplate.update(sql, id);
        return result;
    }
}