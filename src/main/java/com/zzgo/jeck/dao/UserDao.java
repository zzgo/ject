package com.zzgo.jeck.dao;

import com.zzgo.jeck.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User>, UserDaoCustom {
    List<User> findUserByNameLike(String name);
}
