package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.dao.LocationDao;
import com.zzgo.jeck.entity.Location;
import com.zzgo.jeck.service.ILocationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 9527 on 2017/11/16.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LocationService implements ILocationService {
    @Resource
    private LocationDao locationDao;

    public void save(Location location) {
        locationDao.save(location);
    }

    public void delete(String locationId) {
        locationDao.delete(locationId);
    }

    public void update(Location location) {
        locationDao.save(location);
    }

    public List<Location> findAll() {
        return locationDao.findAll();
    }

    public Page<Location> findPage(int first, int max) {
        Pageable pageable = new PageRequest(first - 1, max);
        return locationDao.findAll(pageable);
    }

    public Page<Location> findPage(Specification<Location> specification, int first, int max) {
        Pageable pageable = new PageRequest(first - 1, max);
        return locationDao.findAll(specification, pageable);
    }

    public Location findSensorById(String locationId) {
        return locationDao.findOne(locationId);
    }
}
