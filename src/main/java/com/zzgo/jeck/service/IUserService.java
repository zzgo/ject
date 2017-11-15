package com.zzgo.jeck.service;

import com.zzgo.jeck.entity.Book;
import com.zzgo.jeck.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
public interface IUserService {
    void save(User user);

    void delete(String id);

    User findUserById(String id);

    Page<User> findPage(int first, int max);

    //用于过滤条件查询
    Page<User> findPage(Specification<User> specification, int first, int max);

    List<Book> findBookByUserId(String userId);

    List<User> findUserByNameLike(String name);

}
