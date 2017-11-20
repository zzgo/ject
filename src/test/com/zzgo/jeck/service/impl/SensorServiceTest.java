package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.entity.Location;
import com.zzgo.jeck.entity.Sensor;
import com.zzgo.jeck.service.ISensorService;
import com.zzgo.jeck.utils.DateUtil;
import com.zzgo.jeck.utils.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 9527 on 2017/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SensorServiceTest {
    @Resource
    private ISensorService sensorService;

    @Test
    public void save() throws Exception {
        for (int i = 2; i < 20; i++) {
            Location location = new Location();
            location.setId("d98dde68-ddcf-4b2d-9998-9b5eb9bf0864");
            Sensor sensor = new Sensor();
            sensor.setCreateTime(DateUtil.getTimestamp());
            sensor.setId(UUIDUtil.getUUID());
            sensor.setDescription("");
            sensor.setLocation(location);
            sensor.setModel(UUIDUtil.getUUID());
            sensor.setName("传感器" + i);
            sensorService.save(sensor);
        }
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findPage() throws Exception {
        Page<Sensor> page = sensorService.findPage(1, 10);
        System.out.println();
    }

    @Test
    public void findPage1() throws Exception {

    }

    @Test
    public void findSensorById() throws Exception {
        Sensor sensor = sensorService.findSensorById("85de24f9-9ba3-4607-b6f2-7d71f2688bf4");
        System.out.println();
    }

}