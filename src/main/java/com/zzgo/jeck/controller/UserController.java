package com.zzgo.jeck.controller;

import com.zzgo.jeck.entity.User;
import com.zzgo.jeck.extend.PageDataExtend;
import com.zzgo.jeck.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 9527 on 2017/11/9.
 */
@Controller
@RequestMapping("admin/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 列表
     * 考虑分页
     */
    @RequestMapping("/list")
    ModelAndView list(Integer pageNum) {
        pageNum = null == pageNum || pageNum < 1 ? 1 : pageNum;
        Page<User> userPage = userService.findPage(pageNum, 10);
        PageDataExtend page = new PageDataExtend(userPage.getContent(), pageNum, 10, (int) userPage.getTotalElements());
        ModelAndView mv = new ModelAndView();
        mv.addObject("page", page);
        mv.setViewName("admin/user/list");
        return mv;
    }

    /**
     * 增页面
     */

    /**
     * 增处理
     */

    /**
     * 删处理
     */

    /**
     * 改页面
     */

    /**
     * 改处理
     */

    /**
     * 查询
     */
}
