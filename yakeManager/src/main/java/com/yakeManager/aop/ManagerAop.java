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
public class ManagerAop {
    @Pointcut("execution(* com.yakeManager.controller.managerController.Manager.m*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object trackInfo(ProceedingJoinPoint pjp) throws Throwable {
        User user;
        String client_id;

        try {
            //获取当前Session,并判断当前访问是否处于登录状态，若位处于登录状态，则立刻跳转去登录
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session=attr.getRequest().getSession(true);


            user= (User) session.getAttribute("loginManager");
            client_id= (String)  session.getAttribute("manager_id");

        }
        catch (Exception e){

            System.out.println("----->没有管理员权限被拦截");
            return "redirect:noManager";
        }
        if(client_id==null || "".equals(client_id))
        {

            System.out.println("----->没有管理员权限被拦截");

            return "redirect:noManager";
        }

        return pjp.proceed();
    }
}
