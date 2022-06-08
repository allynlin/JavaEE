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
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author Allyn
 */
@Service
@Transactional
@Repository
public class StudentServiceImpl implements StudentService {

  @Resource private JdbcTemplate jdbcTemplate;
  //
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public List<Student> findStudentsByName(String username) {
    if (username == null || username.trim().equals("")) {
      username = "";
    }

    String sql = "select * from studentmanagement.student where username like ?";
    List<Student> students = null;
    try {
      RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
      students = jdbcTemplate.query(sql, new Object[] {"%" + username + "%"}, rowMapper);
    } catch (DataAccessException e) {
      return null;
    }
    return students;
  }

  @Override
  public String addStudent(Student student) {
    String sql =
        "insert into studentmanagement.student(username,age,userclass,pimage) values(?,?,?,?)";
    int result =
        jdbcTemplate.update(
            sql,
            new Object[] {
              student.getUsername(), student.getAge(), student.getUserclass(), student.getPimage()
            });
    String res;
    if (result == 1) {
      res = "添加成功,您添加的学生是：" + student.getUsername();
      //            return student.getId();
    } else {
      res = "添加失败";
    }
    return res;
  }

  @Override
  public int updateStudent(Student student) {
    System.out.println(
        "获取到了id为："
            + student.getId()
            + "，姓名为:"
            + student.getUsername()
            + ",年龄为:"
            + student.getAge()
            + ",班级为:"
            + student.getUserclass()
            + "的学生");
    String sql =
        "update studentmanagement.student set username = ?,age = ?,userclass = ? where id = ?";
    int result =
        jdbcTemplate.update(
            sql, student.getUsername(), student.getAge(), student.getUserclass(), student.getId());
    return result;
  }

  @Override
  public int deleteStudent(int id) {
    String sql = "delete from studentmanagement.student where id = ?";
    int result = jdbcTemplate.update(sql, id);
    return result;
  }
}
