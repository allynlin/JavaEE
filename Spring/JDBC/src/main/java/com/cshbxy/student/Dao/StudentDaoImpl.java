package com.cshbxy.student.Dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addStudent(Student student) {
        String sql = "insert into student(username,password,course) values(?,?,?)";
        Object obj[] = {student.getUsername(), student.getPassword(), student.getCourse()};
        //执行添加操作，返回的是受SQL语句影响的记录数
        int count = jdbcTemplate.update(sql, obj);
        return count;
    }

    public int deleteStudent(int id) {
        String sql = "delete from student where id = ?";
        int count = jdbcTemplate.update(sql, id);
        return count;
    }

    public int updateStudent(Student student) {
        String sql = "update student set username = ?,password = ?,course = ? where id = ?";
        Object obj[] = {student.getUsername(), student.getPassword(), student.getCourse(), student.getId()};
        int count = jdbcTemplate.update(sql, obj);
        return count;
    }

    public Student findStudentById(int id) {
        String sql = "select * from student where id = ?";
        //如果查询失败返回空
        Student student = null;
        try {
            student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return student;
    }

    //查询所有学生信息
    public List<Student> findAllStudent() {
        String sql = "select * from student";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public Student findStudentByUsernameAndPassword(String username, String password) {
        String sql = "select * from student where username = ? and password = ?";
        Student student = null;
        try {
            student = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), username, password);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return student;
    }

    //通过姓名和course模糊查询
    public List<Student> findStudentByUsernameAndCourse(String username, String course) {
        String sql = "select * from student where username like ? and course like ?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        return this.jdbcTemplate.query(sql, rowMapper, "%" + username + "%", "%" + course + "%");
    }
}
