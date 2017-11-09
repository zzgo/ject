package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.dao.NavDao;
import com.zzgo.jeck.entity.Nav;
import com.zzgo.jeck.service.INavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NavService implements INavService {

    @Autowired
    private NavDao navDao;

    public void save(Nav nav) {
        navDao.save(nav);
    }

    public void delete(String id) {
        navDao.delete(id);
    }

    public List<Nav> findAll() {
        return navDao.findAll();
    }

    public List<Nav> findAll(String parentId) {
        return navDao.findAll(parentId);
    }

    public List<Nav> findNavByParentId(String parentId) {

        return navDao.findNavByParentId(parentId);
    }

    public Nav findOne(String id) {
        return navDao.findOne(id);
    }
}
