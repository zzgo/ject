package com.zzgo.jeck.service;

import com.zzgo.jeck.entity.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by 9527 on 2017/11/16.
 */
public interface ILocationService {
    void save(Location location);

    void delete(String locationId);

    void update(Location location);

    List<Location> findAll();

    Page<Location> findPage(int first, int max);

    //用于过滤条件查询
    Page<Location> findPage(Specification<Location> specification, int first, int max);

    Location findSensorById(String locationId);
}
