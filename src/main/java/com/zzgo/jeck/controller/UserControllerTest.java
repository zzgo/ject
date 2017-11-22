package com.zzgo.jeck.controller;

public class UserControllerTest {

}

//import com.zzgo.jeck.entity.User;
//import com.zzgo.jeck.vo.PageDataVo;
//import com.zzgo.jeck.service.IUserService;
//import com.zzgo.jeck.utils.DateUtil;
//import com.zzgo.jeck.utils.UUIDUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by 9527 on 2017/11/9.
// */
//@Controller
//@RequestMapping("admin/user")
//public class UserController extends BaseController {
//    private Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    private IUserService userService;
//
//    /**
//     * 列表
//     * 考虑分页
//     */
//    @ResponseBody
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    Map<String, Object> list(@RequestParam(required = false, defaultValue = "1") Integer pageNum, @RequestParam
//            (required =
//                    false, defaultValue = "10") Integer pageSize) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        try {
//            pageNum = pageNum < 1 ? 1 : pageNum;
//            Page<User> userPage = userService.findPage(pageNum, pageSize);
//            if (userPage.getTotalPages() < pageNum) {
//                pageNum = userPage.getTotalPages();
//                userPage = userService.findPage(pageNum, pageSize);
//            }
//            PageDataVo page = new PageDataVo(userPage.getContent(), pageNum, pageSize, (int) userPage
//                    .getTotalElements());
//            result.put("data", page);
//            return ajaxResponse(result, 200, "");
//        } catch (Exception e) {
//            logger.info("request [admin/user/list] is error,message= ", e);
//            result.put("error", e);
//            return ajaxResponse(result, 500, "");
//        }
//    }
//    /**
//     * 增处理
//     */
//    @ResponseBody
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    Map<String, Object> save(User user) {
//        try {
//            user.setId(UUIDUtil.getUUID());
//            user.setCreateTime(DateUtil.getTimestamp());
//            userService.save(user);
//            return ajaxResponse(null, 200, "");
//        } catch (Exception e) {
//            Map<String, Object> result = new HashMap<String, Object>();
//            logger.info("request [admin/user/save] is error,message= ", e);
//            result.put("error", e);
//            return ajaxResponse(result, 500, "");
//        }
//    }
//
//    /**
//     * 删处理
//     */
//    @ResponseBody
//    @RequestMapping(value = "/delete", method = RequestMethod.GET)
//    Map<String, Object> delete(@RequestParam(required = true, defaultValue = "0") String uuid) {
//        try {
//            userService.delete(uuid);
//            return ajaxResponse(null, 200, "");
//        } catch (Exception e) {
//            Map<String, Object> result = new HashMap<String, Object>();
//            logger.info("request [admin/user/delete] is error,message= ", e);
//            result.put("error", e);
//            return ajaxResponse(result, 500, "");
//        }
//    }
//
//    /**
//     * 改处理
//     */
//    @ResponseBody
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    Map<String, Object> update(User user0) {
//        try {
//            User user = userService.findUserById(user0.getId());
//            //指定你去修改那一些。
//            user.setName(user0.getName());
//            user.setPassword(user0.getPassword());
//            userService.save(user);
//        } catch (Exception e) {
//            Map<String, Object> result = new HashMap<String, Object>();
//            logger.info("request [admin/user/update] is error,message= ", e);
//            result.put("error", e);
//            return ajaxResponse(result, 500, "");
//        }
//        return ajaxResponse(null, 200, "");
//    }
//
//    /**
//     * 查询
//     */
//    @ResponseBody
//    @RequestMapping("/query")
//    Map<String, Object> query(@RequestParam(required = true, defaultValue = "") String queryParam) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        try {
//            List<User> userList = userService.findUserByNameLike(queryParam);
//            result.put("data", userList);
//            return ajaxResponse(result, 200, "");
//        } catch (Exception e) {
//            logger.info("request [admin/user/query] is error,message= ", e);
//            result.put("error", e);
//            return ajaxResponse(result, 500, "");
//        }
//    }
//
//}
