package cn.zwsheng.lostandfound.controller;

import cn.zwsheng.lostandfound.service.IPickThingsService;
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
public class PickThingsController {

    @Autowired
    IPickThingsService pickThingsService;

    @RequestMapping("/pickthingList.html")
    public ModelAndView lostthingListView() {
        ModelAndView modelAndView = new ModelAndView("things/pickthingList");
        modelAndView.addObject("title","拾物认领信息");
        modelAndView.addObject("pickThingList",pickThingsService.findAll());
        return modelAndView;
    }

    @RequestMapping("/publishPickthing.html")
    public ModelAndView publishLostthingView(){
        ModelAndView modelAndView = new ModelAndView("things/publishPickthing");
        modelAndView.addObject("title","发布拾物认领信息");
        return modelAndView;
    }

    @RequestMapping("/publishPickthing")
    public ModelAndView publishLostthing(HttpServletRequest request, @RequestParam("thingImg") MultipartFile thingImg){
        String fileName = thingImg.getOriginalFilename();
        fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".")+1);
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
        try{
            pickThingsService.publishLostthing(request,fileName);
        }catch (Exception e){
            return publishLostthingView();
        }

        return lostthingListView();
    }
}
