package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.entity.Location;
import com.zzgo.jeck.service.ILocationService;
import com.zzgo.jeck.utils.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 9527 on 2017/11/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class LocationServiceTest {
    @Resource
    private ILocationService locationService;

    @Test
    public void save() throws Exception {
        Location location = new Location();
        location.setId(UUIDUtil.getUUID());
        location.setBuilding("1栋");
        location.setFloor("2楼");
        location.setRoom("05室");
        location.setOther("");
        location.setShortName("1-02-05");
        locationService.save(location);
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
    }

    @Test
    public void findPage1() throws Exception {
    }

    @Test
    public void findSensorById() throws Exception {
    }

}