package com.zzgo.jeck.dao;

import com.zzgo.jeck.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 9527 on 2017/11/9.
 */
public interface BookDao extends JpaRepository<Book, String>, JpaSpecificationExecutor<Book>, BookDaoCustom {

}
