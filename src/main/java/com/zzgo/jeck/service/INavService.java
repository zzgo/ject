package com.zzgo.jeck.service;

import com.zzgo.jeck.entity.Nav;

import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
public interface INavService {
    void save(Nav nav);

    void delete(String id);

    List<Nav> findAll();

    Nav findOne(String id);

    List<Nav> findAll(String parentId);

    List<Nav> findNavByParentId(String parentId);

}
