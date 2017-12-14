package com.zzgo.jeck.controller;

import com.zzgo.jeck.entity.Sensor;
import com.zzgo.jeck.service.ISensorService;
import com.zzgo.jeck.utils.DateUtil;
import com.zzgo.jeck.utils.UUIDUtil;
import com.zzgo.jeck.vo.DeviceVo;
import com.zzgo.jeck.vo.PageDataVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sensor")
public class SensorController extends BaseController {
    private static final String preView = "sensor/";
    private Logger logger = LoggerFactory.getLogger(SensorController.class);

    @Autowired
    private ISensorService sensorService;

    @Resource
    private ServletContext servletContext;

    //列表
    @RequestMapping(value = "list")
    public ModelAndView list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                             @RequestParam(value = "s", required
                                     = false, defaultValue = "10") int pageSize) {
        ModelAndView mv = new ModelAndView();
        if (pageNum < 1) pageNum = 1;
        Page<Sensor> sensorPage = sensorService.findPage(pageNum, pageSize);
        int totalPage = sensorPage.getTotalPages();
        if (totalPage < pageNum && totalPage > 0) {
            sensorPage = sensorService.findPage(totalPage, pageSize);
        }
        PageDataVo<Sensor> pageDataVo = new PageDataVo<Sensor>(sensorPage.getContent(), pageNum, pageSize,
                (int) sensorPage.getTotalElements());
        mv.addObject("pd", pageDataVo);
        mv.setViewName(preView + "list");
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
    @RequestMapping(value = "add")
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(preView + "edit");
        return mv;
    }

    //增加
    @ResponseBody
    @RequestMapping(value = "save")
    public Map<String, Object> save(Sensor sensor) {
        try {
            sensor.setCreateTime(DateUtil.getTimestamp());
            sensor.setId(UUIDUtil.getUUID());
            //sensor.setReminding(0);
            sensorService.save(sensor);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            logger.info("Sensor save fail because ", e);
            return ajaxResponse(null, 500, e.getMessage());
        }
    }

    //修改页面
    @RequestMapping(value = "edit")
    public ModelAndView modify(String sensorId, String p, String s) {
        ModelAndView mv = new ModelAndView();
        //查询实体
        Sensor sensor = sensorService.findSensorById(sensorId);
        //具体操作
        mv.addObject("sensor", sensor);
        mv.addObject("pVo", p);
        mv.addObject("sVo", s);
        mv.setViewName(preView + "edit");
        return mv;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "update")
    public Map<String, Object> update(Sensor sensor0) {
        try {
            Sensor sensor = sensorService.findSensorById(sensor0.getId());
            sensor.setUpdateTime(DateUtil.getTimestamp());
            sensor.setDescription(sensor0.getDescription());
            sensor.setName(sensor0.getName());
            sensor.setModel(sensor0.getModel());
            sensor.setLocation(sensor0.getLocation());
            sensorService.save(sensor);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            logger.info("Sensor update fail because ", e);
            return ajaxResponse(null, 500, e.getMessage());
        }
    }

    /**
     * 删处理
     */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    Map<String, Object> delete(@RequestParam(required = true, defaultValue = "0") String sensorId) {
        try {
            sensorService.delete(sensorId);
            return ajaxResponse(null, 200, "");
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<String, Object>();
            logger.info("request [admin/sensor/delete] is error,message= ", e);
            result.put("error", e);
            return ajaxResponse(result, 500, "");
        }
    }

    /**
     * 实时数据
     */
    @ResponseBody
    @RequestMapping(value = "info", method = RequestMethod.GET)
    Map<String, Object> info() {
        try {
            Map<String, Object> result = new HashMap<String, Object>();
            List<DeviceVo> deviceVos = (List<DeviceVo>) servletContext.getAttribute("devices");
            result.put("data", deviceVos);
            return ajaxResponse(result, 200, "");
        } catch (Exception e) {
            Map<String, Object> result = new HashMap<String, Object>();
            logger.info("request [admin/sensor/info] is error,message= ", e);
            result.put("error", e);
            return ajaxResponse(result, 500, "");
        }
    }
}
