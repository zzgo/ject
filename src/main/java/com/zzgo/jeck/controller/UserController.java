package com.zzgo.jeck.controller;

import com.zzgo.jeck.entity.User;
import com.zzgo.jeck.vo.PageDataVo;
import com.zzgo.jeck.service.IUserService;
import com.zzgo.jeck.utils.DateUtil;
import com.zzgo.jeck.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by 9527 on 2017/11/22.
 */
@Controller
@RequestMapping(value = "admin/user")
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    //列表
    @RequestMapping(value = "list")
    public ModelAndView list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                             @RequestParam(value = "s", required
                                     = false, defaultValue = "10") int pageSize) {
        ModelAndView mv = new ModelAndView();
        if (pageNum < 1) pageNum = 1;
        Page<User> userPage = userService.findPage(pageNum, pageSize);
        int totalPage = userPage.getTotalPages();
        if (totalPage < pageNum) {
            userPage = userService.findPage(totalPage, pageSize);
        }
        PageDataVo<User> pageDataVo = new PageDataVo<User>(userPage.getContent(), pageNum, pageSize,
                (int) userPage.getTotalElements());
        mv.addObject("pd", pageDataVo);
        mv.setViewName("admin/user/list");
        return mv;
    }

    //查询列表
    @RequestMapping(value = "query")
    public ModelAndView list(String q) {
        ModelAndView mv = new ModelAndView();
        //具体操作
        mv.addObject("", "");
        mv.setViewName("");
        return mv;
    }

    //增加页面
    @RequestMapping(value = "modify")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        //具体操作
        mv.addObject("", "");
        mv.setViewName("");
        return mv;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "save")
    public Map<String, Object> save(User user) {
        try {
            user.setId(UUIDUtil.getUUID());
            user.setCreateTime(DateUtil.getTimestamp());
            user.setLoginCount(0);
            //Map<String, Object> result = new HashMap<String, Object>();
            userService.save(user);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            logger.info("User save fail because ", e);
            return ajaxResponse(null, 500, e.getMessage());
        }
    }

    //修改页面
    @RequestMapping(value = "modify")
    public ModelAndView modify(String userId) {
        //查询实体
        //填充需要改变的属性
        //更新实体
        ModelAndView mv = new ModelAndView();
        //具体操作
        mv.addObject("", "");
        mv.setViewName("");
        return mv;
    }
    //修改

    @RequestMapping(value = "update")
    public Map<String, Object> update(User user0) {
        //查询实体
        //填充需要改变的属性
        //更新实体
        //删除
        return ajaxResponse(null, 500, "");
    }


    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            System.out.println("e.getMessage()==" + e.getMessage());
            System.out.println("e.getStackTrace()==" + e.getStackTrace());
            System.out.println("e.getCause()==" + e.getCause());
            System.out.println("e.getClass()==" + e.getClass());
            System.out.println("e.getLocalizedMessage()==" + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

}
