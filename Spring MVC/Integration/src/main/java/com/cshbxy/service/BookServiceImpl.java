package com.cshbxy.service;

import com.cshbxy.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
//    private BookMapper bookMapper;

    @Override
    public Book findById(int id) {
        return null;
    }
}
