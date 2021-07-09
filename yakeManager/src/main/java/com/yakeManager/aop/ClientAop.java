package com.yakeManager.aop;

import com.yakeManager.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Component
@Aspect
public class ClientAop {
    @Pointcut("execution(* com.yakeManager.controller.ClientControl.m*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object trackInfo(ProceedingJoinPoint pjp) throws Throwable {
        User user;
        String client_id;

        try {
            //获取当前Session,并判断当前访问是否处于登录状态，若位处于登录状态，则立刻跳转去登录
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session=attr.getRequest().getSession(true);


            user= (User) session.getAttribute("loginClient");
            client_id= (String)  session.getAttribute("client_id");

        }
        catch (Exception e){

            System.out.println("----->没有用户账号权限被拦截");
            return "redirect:noUser";
        }
        if(client_id == null || "".equals(client_id))
        {

            System.out.println("----->没有用户账号权限被拦截");
            return "redirect:noUser";
        }

        return pjp.proceed();
    }
}

