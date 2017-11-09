package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.entity.Book;
import com.zzgo.jeck.entity.User;
import com.zzgo.jeck.service.IBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceTest {
    @Resource
    private IBookService bookService;

    @Test
    public void saveTest() throws Exception {
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            User user = new User();
            user.setId("testUser" + i);
            book.setId("bookId" + i);
            book.setName("bookName" + i);
            book.setUser(user);
            bookService.save(book);
        }
    }

    @Test
    public void deleteTest() throws Exception {
        bookService.delete("ssssssss");
    }

    @Test
    public void findOneTest() throws Exception {
        System.out.println(bookService.findOne("ssssssss"));
    }

    @Test
    public void updateTest() throws Exception {
        Book book = new Book();
        User user = new User();
        user.setId("testUser0");
        book.setId("ssssssss");
        book.setName("bookNameUP");
        book.setUser(user);
        bookService.update(book);
    }

    @Test
    public void findAllTest() throws Exception {
        List<Book> books = bookService.findAll();

        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }

}