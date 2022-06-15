package com.cshbxy.service;

import com.cshbxy.pojo.Book;

public interface BookService {

    // 按id查找图书信息
    Book findById(int id);
}
