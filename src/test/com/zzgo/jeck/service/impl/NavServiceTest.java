package com.zzgo.jeck.service.impl;

import com.zzgo.jeck.entity.Nav;
import com.zzgo.jeck.service.INavService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class NavServiceTest {
    @Resource
    private INavService navService;

    @Test
    public void save() throws Exception {
        /*Nav nav = new Nav();
        //Nav parent = new Nav();
        nav.setId("sadasdsadsa");
        nav.setName("testNav");
        nav.setUrl("/index");
        //nav.setParent(parent);
        //parent.setId("setId");
        navService.save(nav);*/
        /**
         * 这个地方有个坑，就是如果你parent对象的个值与数据库中的值不符，则会更新表。
         */
        Nav nav = new Nav();
        Nav parent = navService.findOne("sadasdsadsa");
        nav.setId("sadjsakd12123");
        nav.setName("testNav");
        nav.setUrl("/index");
        nav.setParent(parent);
        navService.save(nav);

    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
        List<Nav> navList = navService.findAll();
        System.out.println(Arrays.asList(navList));
    }

    @Test
    public void findAll1() throws Exception {
        List<Nav> navList = navService.findAll("dsjakdjaskdas");
        System.out.println(Arrays.asList(navList));
    }

    @Test
    public void findNavByParentId() throws Exception {

    }

}