package cn.zwsheng.lostandfound.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/things")
public class ThingController {

    @RequestMapping("/thingDetail.html")
    public ModelAndView thingDetailView(){
        ModelAndView modelAndView = new ModelAndView("things/thingDetail");
        return modelAndView;
    }
}
