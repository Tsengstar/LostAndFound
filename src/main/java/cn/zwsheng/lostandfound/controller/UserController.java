package cn.zwsheng.lostandfound.controller;

import cn.zwsheng.lostandfound.domain.Loginlog;
import cn.zwsheng.lostandfound.domain.User;
import cn.zwsheng.lostandfound.service.ILoginlogService;
import cn.zwsheng.lostandfound.service.IUserService;
import cn.zwsheng.lostandfound.util.VerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * 用户的控制
 */
@RestController
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService userService;

    @Autowired
    private ILoginlogService loginlogService;

    @RequestMapping(value="/login")
    public boolean login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String username = (String) request.getParameter("user");
        String password = (String) request.getParameter("pwd");
        String ip = request.getRemoteAddr();
        User current = userService.login(username, password);
        Loginlog loginlog = new Loginlog();
        loginlog.setIp(ip);
        loginlog.setLoginTime(new Date());
        loginlog.setUsername(username);
        if(current==null){
            loginlog.setState(Loginlog.LOGIN_FAILED);
            loginlogService.save(loginlog);
            return false;
        }else{
            loginlog.setState(Loginlog.LOGIN_SUCCESS);
            session.setAttribute("logininfo",current);
            session.setMaxInactiveInterval(1800);
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(60*30);
            response.addCookie(cookie);
            loginlogService.save(loginlog);
            return true;
        }

    }
    @RequestMapping("/createImg")
    public void createImg(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            VerifyUtil randomValidateCode = new VerifyUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片
            String loginVerify = (String)session.getAttribute(VerifyUtil.RANDOMCODEKEY);
            session.setAttribute("loginVerify",loginVerify);
            //设置失效时间1分钟
            session.setMaxInactiveInterval(60);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
    @RequestMapping("/checkVerifyIsTrue")
    public boolean checkVerifyIsTrue(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String verify = request.getParameter("verify");
        String loginVerify = (String)session.getAttribute("loginVerify");
        if (verify.equalsIgnoreCase(loginVerify)){
            return true;
        }
        return false;
    }
    @RequestMapping("/login.html")
    public ModelAndView loginView(){
        return new ModelAndView("login");
    }
}