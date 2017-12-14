package com.zzgo.jeck.dao.impl;

import com.zzgo.jeck.dao.RecordDao;
import com.zzgo.jeck.dao.RecordDaoCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RecordDaoImpl implements RecordDaoCustom {
    @PersistenceContext
    private EntityManager em;
}
