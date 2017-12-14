package com.zzgo.jeck.dao;

import com.zzgo.jeck.entity.Book;
import com.zzgo.jeck.entity.User;

import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
public interface UserDaoCustom {

    List<User> findPage(int first, int max);



    List<Book> findBookByUserId(String userId);


}
