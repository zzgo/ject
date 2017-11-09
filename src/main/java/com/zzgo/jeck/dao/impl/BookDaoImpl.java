package com.zzgo.jeck.dao.impl;

import com.zzgo.jeck.dao.BookDaoCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by 9527 on 2017/11/9.
 */
public class BookDaoImpl implements BookDaoCustom {
    @PersistenceContext
    private EntityManager em;
}
