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
import java.util.Random;

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
        Random r = new Random();
        for (int i = 0; i < 200; i++) {
            //Sensor sensor = new Sensor();
            //sensor.setCreateTime(DateUtil.getTimestamp());
            //sensor.setId(UUIDUtil.getUUID());
            //sensor.setDescription("");
            //sensor.setModel(UUIDUtil.getUUID());
            //sensor.setName("设备" + i);
            //int i1 = r.nextInt(32) + 1;
            //int i2 = r.nextInt(8) + 1;
            //int i3 = r.nextInt(4) + 1;
            //sensor.setBuilding(i1);
            //sensor.setFloor(i2);
            //sensor.setRoom(i3);
            //sensor.setShortName(i1 + "-" + i2 + "-" + i3);
            //sensorService.save(sensor);
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