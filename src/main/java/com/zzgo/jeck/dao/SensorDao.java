package com.zzgo.jeck.dao;

import com.zzgo.jeck.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 9527 on 2017/11/16.
 */
public interface SensorDao extends JpaRepository<Sensor, String>, JpaSpecificationExecutor<Sensor>, SensorDaoCustom {

}
