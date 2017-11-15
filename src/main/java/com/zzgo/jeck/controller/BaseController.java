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

}
