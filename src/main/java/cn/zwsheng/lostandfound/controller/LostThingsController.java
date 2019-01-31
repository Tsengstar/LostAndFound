package cn.zwsheng.lostandfound.controller;

import cn.zwsheng.lostandfound.domain.LostThings;
import cn.zwsheng.lostandfound.service.ILostThingsService;
import cn.zwsheng.lostandfound.service.IThingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/things")
public class LostThingsController {

    @Autowired
    private ILostThingsService lostThingsService;

    @Autowired
    private IThingTypeService thingTypeService;

    @RequestMapping("/test")
    public LostThings test(){
        return lostThingsService.getOne();
    }
    @RequestMapping("/publishLostthing.html")
    public ModelAndView publishLostthingView(){
        ModelAndView modelAndView = new ModelAndView("things/publishLostthing");
        modelAndView.addObject("thingTypes",thingTypeService.findAll());
        return modelAndView;
    }
    @RequestMapping("/publishLostthing")
    public String publishLostthing(HttpServletRequest request, HttpServletResponse response){
        String thingName = (String) request.getParameter("thingName");
        String thingType = (String) request.getParameter("thingType");
        String lostPlace = (String) request.getParameter("lostPlace");
        String thingDes = (String) request.getParameter("thingDes");
        String lostTime = (String) request.getParameter("lostTime");
        Map para = request.getParameterMap();
        System.out.println(para.get("thingName"));
        return thingName+" "+thingType+" "+lostPlace+" "+thingDes+" "+lostTime;
    }
}
