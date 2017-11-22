package com.zzgo.jeck.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 9527 on 2017/11/10.
 */
public class BaseController {
    //请求成功
    Map<String, Object> ajaxResponse(Map<String, Object> result, int status, String info) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("info", info);
        map.put("status", status);
        map.put("result", result);
        return map;
    }


    //private Logger logger = LoggerFactory.getLogger(UserController.class);
    //
    //@Autowired
    //private IUserService userService;
    //
    ////列表
    //@RequestMapping(value = "list")
    //public ModelAndView list(@RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam(required
    //        = false, defaultValue = "10") int pageSize) {
    //    ModelAndView mv = new ModelAndView();
    //    //具体操作
    //    mv.addObject("", "");
    //    mv.setViewName("");
    //    return mv;
    //}
    //
    ////查询列表
    //@RequestMapping(value = "query")
    //public ModelAndView list(String q) {
    //    ModelAndView mv = new ModelAndView();
    //    //具体操作
    //    mv.addObject("", "");
    //    mv.setViewName("");
    //    return mv;
    //}
    //
    ////增加页面
    //public ModelAndView add() {
    //    ModelAndView mv = new ModelAndView();
    //    //具体操作
    //    mv.addObject("", "");
    //    mv.setViewName("");
    //    return mv;
    //}
    //
    ////增加
    //@ResponseBody
    //@RequestMapping(value = "save")
    //public Map<String, Object> save(User user) {
    //    try {
    //        user.setId(UUIDUtil.getUUID());
    //        user.setCreateTime(DateUtil.getTimestamp());
    //        user.setLoginCount(0);
    //        //Map<String, Object> result = new HashMap<String, Object>();
    //        userService.save(user);
    //        return ajaxResponse(null, 200, "");
    //    } catch (Exception e) {
    //        logger.info("User save fail because ", e);
    //        return ajaxResponse(null, 500, e.getMessage());
    //    }
    //}
    //
    ////修改页面
    //@RequestMapping(value = "modify")
    //public ModelAndView modify(String userId) {
    //    //查询实体
    //    //填充需要改变的属性
    //    //更新实体
    //    ModelAndView mv = new ModelAndView();
    //    //具体操作
    //    mv.addObject("", "");
    //    mv.setViewName("");
    //    return mv;
    //}
    ////修改
    //
    //@RequestMapping(value = "update")
    //public Map<String, Object> update(User user0) {
    //    //查询实体
    //    //填充需要改变的属性
    //    //更新实体
    //    //删除
    //    return ajaxResponse(null, 500, "");
    //}

}
