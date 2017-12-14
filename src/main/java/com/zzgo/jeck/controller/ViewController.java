package com.zzgo.jeck.controller;

import com.zzgo.jeck.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by 9527 on 2017/11/16.
 */
@Controller
public class ViewController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "index")
    public String index() {
        return "index/index";
    }

    @ResponseBody
    @RequestMapping("/logindo")
    public Map<String, Object> logindo(User user) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
            token.setRememberMe(false);
            SecurityUtils.getSubject().login(token);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            logger.info("", e);
            return ajaxResponse(null, 500, "");
        }
    }

    @RequestMapping("/login")
    public String login(User user) {
        return "login/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return "redirect:/login";
    }
}
