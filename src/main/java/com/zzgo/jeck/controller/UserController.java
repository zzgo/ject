package com.zzgo.jeck.controller;

import com.zzgo.jeck.entity.Role;
import com.zzgo.jeck.entity.Setting;
import com.zzgo.jeck.entity.User;
import com.zzgo.jeck.query.Criterion;
import com.zzgo.jeck.query.QueryCondition;
import com.zzgo.jeck.query.Restrictions;
import com.zzgo.jeck.service.IRoleService;
import com.zzgo.jeck.utils.Md5Util;
import com.zzgo.jeck.utils.Md5Util_Old;
import com.zzgo.jeck.vo.PageDataVo;
import com.zzgo.jeck.service.IUserService;
import com.zzgo.jeck.utils.DateUtil;
import com.zzgo.jeck.utils.UUIDUtil;
import com.zzgo.jeck.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Map;

/**
 * Created by 9527 on 2017/11/22.
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends BaseController {
    private static final String preView = "user/";
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private ServletContext servletContext;

    //列表
    @RequestMapping(value = "list")
    public ModelAndView list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                             @RequestParam(value = "s", required
                                     = false, defaultValue = "0") int pageSize, @RequestParam(value = "q", required
            = false, defaultValue = "") String query) {
        ModelAndView mv = new ModelAndView();
        //这个地方设置，如果没有指定s
        if (pageSize == 0) {
            Setting setting = (Setting) servletContext.getAttribute("baseSet");
            pageSize = setting.getPageSize();
        }

        if (pageNum < 1) pageNum = 1;
        QueryCondition<User> criteria = new QueryCondition<User>();
        if (query == "" || query.length() < 1) {
            criteria = null;
        } else if (query.length() >= 1) {
            criteria.add(Restrictions.like("loginName", query, Criterion.MatchMode.ANYWHERE));
            criteria.add(Restrictions.like("name", query, Criterion.MatchMode.ANYWHERE));
            criteria.setOr(true);
        }
        Page<User> userPage = userService.findPage(criteria, pageNum, pageSize);
        int totalPage = userPage.getTotalPages();
        if (totalPage < pageNum && totalPage > 0) {
            userPage = userService.findPage(criteria, totalPage, pageSize);
        }
        PageDataVo<User> pageDataVo = new PageDataVo<User>(userPage.getContent(), pageNum, pageSize,
                (int) userPage.getTotalElements());
        pageDataVo.setQuery(query);
        mv.addObject("pd", pageDataVo);
        mv.setViewName("user/list");
        return mv;
    }

    //增加页面
    @RequestMapping(value = "add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(preView + "edit");
        return mv;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "save")
    public Map<String, Object> save(User user) {
        try {
            user.setId(UUIDUtil.getUUID());
            user.setCreateTime(DateUtil.getTimestamp());
            user.setPassword(Md5Util_Old.MD5Encode(user.getPassword()));
            //user.setLoginCount(0);
            userService.save(user);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            logger.info("User save fail because ", e);
            return ajaxResponse(null, 500, e.getMessage());
        }
    }

    //修改页面
    @RequestMapping(value = "edit")
    public ModelAndView modify(String userId, String p, String s) {
        ModelAndView mv = new ModelAndView();
        //查询实体
        User user = userService.findUserById(userId);
        //具体操作
        mv.addObject("user", user);
        mv.addObject("pVo", p);
        mv.addObject("sVo", s);
        mv.setViewName(preView + "edit");
        return mv;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "update")
    public Map<String, Object> update(User user0) {
        try {
            //查询实体
            User user = userService.findUserById(user0.getId());
            if (!user.getPassword().equals(user0.getPassword())) {
                user.setPassword(Md5Util_Old.MD5Encode(user0.getPassword()));
            }
            //改变的属性
            user.setLoginName(user0.getLoginName());
            //更新实体
            userService.save(user);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            logger.info("User update fail because ", e);
            return ajaxResponse(null, 500, e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("delete")
    public Map<String, Object> delete(String userId) {
        try {
            userService.delete(userId);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            logger.info("User update fail because ", e);
            return ajaxResponse(null, 500, e.getMessage());
        }
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

    @RequestMapping("info")
    public ModelAndView info() {
        //从登陆哪里去拿我们拿user
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        ModelAndView mv = new ModelAndView();
        if (user == null) {
            mv.setViewName("login/login");
            return mv;
        }
        mv.setViewName(preView + "info");
        mv.addObject("userinfo", user);
        return mv;
    }

    @RequestMapping("info/edit")
    public ModelAndView infoEdit() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        ModelAndView mv = new ModelAndView();
        if (user == null) {
            mv.setViewName("login/login");
            return mv;
        }
        mv.setViewName(preView + "info_edit");
        mv.addObject("userinfo", user);
        return mv;
    }

    @ResponseBody
    @RequestMapping("info/update")
    public Map<String, Object> infoUpdate(User user0) {
        try {
            //从登陆哪里去拿我们拿user
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            user.setLoginName(user0.getLoginName());
            user.setTel(user0.getTel());
            user.setEmail(user0.getEmail());
            user.setNote(user0.getNote());
            user.setName(user0.getName());
            user.setSex(user0.getSex());
            if (!user.getPassword().equals(user0.getPassword()))
                user.setPassword(Md5Util.GetMD5Code(user0.getPassword()));
            userService.save(user);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            logger.info("User update fail because ", e);
            return ajaxResponse(null, 500, e.getMessage());
        }
    }

    //给用户赋权
    @RequestMapping("rpage")
    public ModelAndView setUserRole(String userId) {
        List<Role> roleList = roleService.findAll();
        User user = userService.findUserById(userId);
        ModelAndView mv = new ModelAndView();
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        mv.addObject("userVo", userVo);
        mv.addObject("roleList", roleList);
        mv.setViewName(preView + "role");
        return mv;
    }


    @ResponseBody
    @RequestMapping("r")
    public Map<String, Object> setRole(User user0) {
        try {
            User user = userService.findUserById(user0.getId());
            Role role = roleService.findRoleById(user0.getRole().getId());
            user.setRole(role);
            userService.save(user);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            logger.info("User update fail because ", e);
            return ajaxResponse(null, 500, e.getMessage());
        }
    }

}
