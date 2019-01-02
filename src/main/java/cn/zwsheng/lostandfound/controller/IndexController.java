package cn.zwsheng.lostandfound.controller;

import cn.zwsheng.lostandfound.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/test")
    public ModelAndView test(Model model){
        System.out.print("test");
        User user = new User();
        user.setId(1L);
        user.setCreateTime(new Date());
        user.setIsNew(1);
        model.addAttribute(user);
        return new ModelAndView("test","userModel",model);
    }
}
