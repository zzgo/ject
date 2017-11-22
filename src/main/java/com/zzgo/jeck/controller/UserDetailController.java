package com.zzgo.jeck.controller;

import com.zzgo.jeck.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 9527 on 2017/11/16.
 */
@RestController
@RequestMapping(value = "account")
public class UserDetailController extends BaseController {
    private static final String preView = "template/user/";
    private Logger logger = LoggerFactory.getLogger(UserDetailController.class);

    @Autowired
    private IUserService userService;

    //个人主页
    @RequestMapping(value = "/")
    public ModelAndView user() {
        ModelAndView mv = new ModelAndView();
        //todo 当前是都是你的账号 如果不是则404
        mv.addObject("user", null);
        mv.setViewName(preView + "info");
        return mv;
    }

}
