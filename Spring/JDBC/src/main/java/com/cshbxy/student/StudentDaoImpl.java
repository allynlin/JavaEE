package com.cshbxy.student;

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
        //ִ�����Ӳ��������ص�����SQL���Ӱ��ļ�¼��
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
        //����һ���µ�BeanPropertyRowMapper����
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    //��ѯ����ѧ����Ϣ
    public List<Student> findAllStudent() {
        String sql = "select * from student";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}