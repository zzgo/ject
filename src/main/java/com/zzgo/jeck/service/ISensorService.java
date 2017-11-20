package com.zzgo.jeck.service;

import com.zzgo.jeck.entity.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by 9527 on 2017/11/16.
 */
public interface ISensorService {
    void save(Sensor sensor);

    void delete(String sensorId);

    void update(Sensor sensor);

    List<Sensor> findAll();

    Page<Sensor> findPage(int first, int max);

    //用于过滤条件查询
    Page<Sensor> findPage(Specification<Sensor> specification, int first, int max);

    Sensor findSensorById(String sensorId);
}
