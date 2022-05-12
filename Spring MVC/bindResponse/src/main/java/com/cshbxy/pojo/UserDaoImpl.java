package com.cshbxy.pojo;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, new Object[]{username, password}, new BeanPropertyRowMapper<User>(User.class));
        }catch (DataAccessException e) {
            return null;
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user(username, password) values(?, ?)";
        Object obj[] = {user.getUsername(), user.getPassword()};
        //执行添加操作，返回的是受SQL语句影响的记录数
        int count = jdbcTemplate.update(sql, obj);
        return count;
    }
}
