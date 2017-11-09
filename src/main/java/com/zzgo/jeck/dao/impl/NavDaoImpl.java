package com.zzgo.jeck.dao.impl;

import com.zzgo.jeck.dao.NavDaoCustom;
import com.zzgo.jeck.entity.Nav;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
public class NavDaoImpl implements NavDaoCustom {
    @PersistenceContext
    private EntityManager em;

    public List<Nav> findAll(String parentId) {
        return em.createQuery(" FROM Nav n WHERE n.parent.id = '" + parentId + "'").getResultList();
    }

    public List<Nav> findNavByParentId(String parentId) {
        return em.createQuery(" FROM Nav n WHERE n.parent.id = '" + parentId + "'").getResultList();
    }
}
