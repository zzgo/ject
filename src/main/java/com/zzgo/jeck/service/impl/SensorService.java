package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.dao.SensorDao;
import com.zzgo.jeck.entity.Sensor;
import com.zzgo.jeck.service.ISensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 9527 on 2017/11/16.
 */
@Service
// rollbackFor：事务回滚
@Transactional(rollbackFor = Exception.class)
public class SensorService implements ISensorService {
    @Autowired
    private SensorDao sensorDao;

    public void save(Sensor sensor) {
        sensorDao.save(sensor);
    }

    public void delete(String sensorId) {
        sensorDao.delete(sensorId);
    }

    public void update(Sensor sensor) {
        sensorDao.save(sensor);
    }

    public List<Sensor> findAll() {
        return sensorDao.findAll();
    }

    public Page<Sensor> findPage(int first, int max) {
        Pageable pageable = new PageRequest(first - 1, max);
        return sensorDao.findAll(pageable);
    }

    public Page<Sensor> findPage(Specification<Sensor> specification, int first, int max) {
        Pageable pageable = new PageRequest(first - 1, max);
        return sensorDao.findAll(specification, pageable);
    }

    public Sensor findSensorById(String sensorId) {
        return sensorDao.findOne(sensorId);
    }
}
