package cn.zwsheng.lostandfound.controller;

import cn.zwsheng.lostandfound.domain.LostThings;
import cn.zwsheng.lostandfound.domain.User;
import cn.zwsheng.lostandfound.service.ILostThingsService;
import cn.zwsheng.lostandfound.service.IThingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

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
    public ModelAndView publishLostthingView(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("things/publishLostthing");
        modelAndView.addObject("thingTypes",thingTypeService.findAll());
        modelAndView.addObject("title","发布寻物启事");
        return modelAndView;
    }
    @RequestMapping("/publishLostthing")
    public String publishLostthing(HttpServletRequest request,@RequestParam("thingImg") MultipartFile thingImg){
        if(thingImg.isEmpty()){
            return "false";
        }
        System.out.println(thingImg.getName());
        String fileName = thingImg.getOriginalFilename();
        int size = (int) thingImg.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "D:/lostAndFound-file/uploadImg" ;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            thingImg.transferTo(dest); //保存文件
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "false";
        }
        return lostThingsService.publishLostthing(request,dest.getAbsolutePath()).toString();
    }
    @RequestMapping("/lostthingList.html")
    public ModelAndView lostthingListView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("things/lostthingList");
        modelAndView.addObject("title","寻物启事信息");
        return modelAndView;
    }
}
