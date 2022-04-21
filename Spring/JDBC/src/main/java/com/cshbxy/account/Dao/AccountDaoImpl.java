package com.cshbxy.account.Dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    //定义JdbcTemplate属性及其setter方法
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //添加账户
//    @Override
//    public int addAccount(Account account) {
//        //定义SQL
//        String sql = "insert into account(username,balance) values(?,?)";
//        //定义数组来存放SQL语句中的参数
//        Object[] objects=new Object[]{account.getUsername(),account.getBalance()};
//        //执行添加操作，返回的是受SQL语句影响的记录数
//        int num=this.jdbcTemplate.update(sql,objects);
//        return num;
//    }

    public int addAccount(Account account) {
        //定义SQL
        String sql = "insert into account(username,balance) values(?,?)";
        //定义数组来存放SQL语句中的参数
        Object[] objects = new Object[]{account.getUsername(), account.getBalance()};
        //执行添加操作，返回的是受SQL语句影响的记录数
        int num = this.jdbcTemplate.update(sql, objects);
        return num;
    }

    //更新账户
    @Override
    public int updateAccount(Account account) {
        //定义SQL
        String sql = "update account set username=?,balance=? where id=?";
        //定义数组来存放SQL语句中的参数
        Object[] objects = new Object[]{account.getUsername(), account.getBalance(), account.getId()};
        //执行更新操作，返回的是受SQL语句影响的记录数
        int num = this.jdbcTemplate.update(sql, objects);
        return num;
    }

    //删除账户
    @Override
    public int deleteAccount(int id) {
        //定义SQL
        String sql = "delete from account where id=?";
        //执行删除操作，返回的是受SQL语句影响的记录数
        int num = this.jdbcTemplate.update(sql, id);
        return num;
    }

    //通过id查询单个账户信息
    @Override
    public Account findAccountById(int id) {
        //定义SQL
        String sql = "select * from account where id=?";
        //创建一个新的BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //将id绑定到SQL语句中，并通过RowMapper返回单行记录
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    //查询所有账户信息
    @Override
    public List<Account> findAllAccount() {
        //定义SQL
        String sql = "select * from account";
        //创建一个新的BeanPropertyRowMapper对象
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        //通过RowMapper返回多行记录
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
