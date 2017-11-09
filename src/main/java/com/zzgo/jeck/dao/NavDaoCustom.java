package com.zzgo.jeck.dao;

import com.zzgo.jeck.entity.Nav;

import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
public interface NavDaoCustom {
    List<Nav> findAll(String parentId);

    List<Nav> findNavByParentId(String parentId);
}
