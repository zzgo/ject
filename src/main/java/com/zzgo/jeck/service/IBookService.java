package com.zzgo.jeck.service;

import com.zzgo.jeck.entity.Book;

import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
public interface IBookService {
    void save(Book book);

    void delete(String id);

    Book findOne(String id);

    void update(Book book);

    List<Book> findAll();

}
