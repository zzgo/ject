package com.zzgo.jeck.controller;

import com.zzgo.jeck.entity.User;
import com.zzgo.jeck.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 9527 on 2017/11/16.
 */
@RestController
@RequestMapping(value = "pages/user")
public class UserDetailController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserDetailController.class);

    @Autowired
    private IUserService userService;

    //个人信息
    @RequestMapping(value = "findOne", method = RequestMethod.POST)
    Map<String, Object> findOne() {
        // TODO 权限管理中用户获取
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", null);
        return ajaxResponse(result, 200, "");
    }

    //更新操作
    @RequestMapping(value = "update", method = RequestMethod.POST)
    Map<String, Object> update(User user0) {
        try {
            User user = userService.findUserById(user0.getId());
            user.setEmail(user0.getEmail());
            user.setName(user0.getName());
            user.setSex(user0.getSex());
            user.setTel(user0.getTel());
            user.setNote(user0.getNote());
            userService.save(user);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("error", e);
            logger.info("request [user/save] is error,message= ", e);
            return ajaxResponse(result, 200, "");
        }
    }

}
