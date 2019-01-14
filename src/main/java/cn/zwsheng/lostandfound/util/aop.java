package cn.zwsheng.lostandfound.util;

import cn.zwsheng.lostandfound.service.IMenuitemService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class aop {

    @Autowired
    private IMenuitemService menuitemService;

    @Pointcut("execution(public * cn.zwsheng.lostandfound.controller..*.*View(..))")
    public void menu() {
    }

    @Before("menu()")
    public void menuBefore() throws Throwable{
        System.out.println("before");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.setAttribute("menuitems",menuitemService.getOneMenuitems());
    }

}
