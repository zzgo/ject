package com.zzgo.jeck.dao;

import com.zzgo.jeck.entity.Book;
import com.zzgo.jeck.entity.User;
import com.zzgo.jeck.query.QueryCondition;
import com.zzgo.jeck.query.Restrictions;
import com.zzgo.jeck.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 9527 on 2017/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoTest extends
        AbstractJUnit4SpringContextTests {
    @Resource
    private IUserService userService;

    @Test
    public void saveUserTest() {
        User user = new User();
        for (int i = 0; i < 100; i++) {
            user.setId("testUser" + i);
            user.setName("userName" + i);
            user.setPassword("pass" + i);
            userService.save(user);
        }
    }

    @Test
    public void deleteUserTest() throws Exception {
        String id = "asdsadasdsadsadsad";
        userService.delete(id);
    }

    @Test
    public void findOneTest() throws Exception {
        String id = "asdsadasdsadsadsad";
        User user = userService.findUserById(id);
        System.out.println(user);
    }

    @Test
    public void findPageTest() throws Exception {
        for (int i = 1; i <= 10; i++) {
            Page<User> page = userService.findPage(i, 10);
            List<User> userList = page.getContent();
            System.out.println(Arrays.asList(userList));
            System.out.println("====================================");
        }
    }

    @Test
    public void findPageQueryTest() throws Exception {
        QueryCondition<User> queryCondition = new QueryCondition<User>();
        queryCondition.add(Restrictions.like("name", "userName"));
        Page<User> page = userService.findPage(queryCondition, 3, 10);
        //内容
        List<User> userList = page.getContent();
        //总数
        System.out.println("page.getTotalElements()=" + page.getTotalElements());
        //当前页（从0页开始算起）
        System.out.println("page.getNumber=" + page.getNumber());
        //当前页展示页数
        System.out.println("page.getNumberOfElements()=" + page.getNumberOfElements());
        //查询size
        System.out.println("page.getSize()" + page.getSize());
        //页数
        System.out.println("page.getTotalPages()=" + page.getTotalPages());
        System.out.println(Arrays.asList(userList));
        System.out.println("====================================");
    }

    @Test
    public void findByBookTest() throws Exception {
        List<Book> bookList = userService.findBookByUserId("testUser0");
        System.out.println(Arrays.asList(bookList));
    }
}