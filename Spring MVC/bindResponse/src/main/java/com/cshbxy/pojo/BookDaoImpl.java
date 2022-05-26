package com.cshbxy.pojo;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> findBooksByName(String bookName) {
        if (bookName == null || bookName.trim().equals("")) {
            bookName = "";
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

        String sql = "select * from spring.book where bookName like ?";
        List<Book> book = null;
        try {
            RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
            book = jdbcTemplate.query(sql, new Object[]{"%" + bookName + "%"}, rowMapper);
        } catch (DataAccessException e) {
            return null;
        }
        return book;
    }
}

