package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.dao.UserDao;
import com.zzgo.jeck.entity.Book;
import com.zzgo.jeck.entity.User;
import com.zzgo.jeck.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void delete(String id) {
        userDao.delete(id);
    }

    public User findUserById(String id) {
        return userDao.findOne(id);
    }

    public Page<User> findPage(int first, int max) {
        Pageable pageable = new PageRequest((first - 1), max);
        return userDao.findAll(pageable);
    }

    public Page<User> findPage(Specification<User> specification, int first, int max) {
        Pageable pageable = new PageRequest((first - 1), max);
        return userDao.findAll(specification, pageable);
    }

    public List<Book> findBookByUserId(String userId) {
        return userDao.findBookByUserId(userId);
    }

}
