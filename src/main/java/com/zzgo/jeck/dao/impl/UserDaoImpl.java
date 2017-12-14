package com.zzgo.jeck.dao.impl;

import com.zzgo.jeck.dao.UserDaoCustom;
import com.zzgo.jeck.entity.Book;
import com.zzgo.jeck.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
public class UserDaoImpl implements UserDaoCustom {
    @PersistenceContext
    private EntityManager em;

    public List<User> findPage(int first, int max) {
        return em.createQuery(" FROM User u").setFirstResult((first - 1) * max).setMaxResults(max).getResultList();
    }

    public List<Book> findBookByUserId(String userId) {
        return em.createQuery(" FROM Book b WHERE b.user.id = \'" + userId + "\'").getResultList();
    }

    //public User findUserByLoginNameAndPassword(String loginName, String password) {
    //    return (User) em.createQuery(" FROM User u WHERE u.loginName='" + loginName + "' and u.password='" + password+"'")
    //            .getSingleResult();
    //}

}
