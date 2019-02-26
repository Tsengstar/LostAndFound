package cn.zwsheng.lostandfound.controller;

import cn.zwsheng.lostandfound.service.ILostThingsService;
import cn.zwsheng.lostandfound.service.IThingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/things")
public class LostThingsController {

    @Autowired
    private ILostThingsService lostThingsService;

    @Autowired
    private IThingTypeService thingTypeService;

    @RequestMapping("/publishLostthing")
    public String publishLostthing(HttpServletRequest request, @RequestParam("thingImg") MultipartFile thingImg){
        String fileName = thingImg.getOriginalFilename();
        fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf(".")+1);
        File path = new File("classpath");
        try {
            path = new File(ResourceUtils.getURL("classpath:static").getPath());
        }catch (Exception e){
            e.printStackTrace();
        }
        File file = new File(path.getAbsolutePath() + "/upload/" + fileName);
        try {
            thingImg.transferTo(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        lostThingsService.publishLostthing(request,fileName);
        lostthingListView();
        return path.getAbsolutePath();
    }
    @RequestMapping("/lostthingList.html")
    public ModelAndView lostthingListView() {
        ModelAndView modelAndView = new ModelAndView("things/lostthingList");
        modelAndView.addObject("title","寻物启事信息");
        modelAndView.addObject("lostThingList",lostThingsService.findAll());
        return modelAndView;
    }

    @RequestMapping("/publishLostthing.html")
    public ModelAndView publishLostthingView(){
        ModelAndView modelAndView = new ModelAndView("things/publishLostthing");
        modelAndView.addObject("thingTypes",thingTypeService.findAll());
        return modelAndView;
    }
}
