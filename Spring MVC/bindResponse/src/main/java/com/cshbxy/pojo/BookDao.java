package com.cshbxy.pojo;

import java.util.List;

public interface BookDao {
    public List<Book> findBooksByName(String bookName);
}
