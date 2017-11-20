package com.zzgo.jeck.dao.impl;

import com.zzgo.jeck.dao.LocationDaoCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by 9527 on 2017/11/16.
 */
public class LocationDaoImpl implements LocationDaoCustom {
    @PersistenceContext
    private EntityManager em;
}
