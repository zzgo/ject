package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.dao.BookDao;
import com.zzgo.jeck.entity.Book;
import com.zzgo.jeck.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BookService implements IBookService {

    @Autowired
    private BookDao bookDao;

    public void save(Book book) {
        bookDao.save(book);
    }

    public void delete(String id) {
        bookDao.delete(id);
    }

    public Book findOne(String id) {
        return bookDao.findOne(id);
    }

    public void update(Book book) {
        bookDao.save(book);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }
}
