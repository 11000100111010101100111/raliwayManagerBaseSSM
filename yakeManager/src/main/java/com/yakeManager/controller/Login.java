package com.yakeManager.controller;

import com.yakeManager.pojo.User;
import com.yakeManager.service.serviceInterface.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("login")
public class Login {

    @Resource(name = "userServiceImpl")
    UserService userService;

    @Resource(name = "managerLogin")
    User user;

    @RequestMapping("/manager")
    public String login(HttpServletResponse response) throws IOException {

//        response.setContentType("text/html;charset=utf-8");
//        response.getWriter().write("<script>alert('没有登录信息!去登录!');window.location='adminshow'; </script>");

        return "/managerPage/login";
    }

    @RequestMapping(value = "/manager/home")
    public String msg(@RequestParam(value = "client_id") String client_id,
                      @RequestParam(value = "password") String password,
                      HttpSession session,HttpServletResponse httpResponse) throws IOException {
        if (userService.login(client_id,password)) {
                return home();
        }
        else
            return "redirect:";
    }

    @RequestMapping("/managerHome")
    public String home(){
        return "managerPage/managerHome";
    }

    //重定向回管理主页
    @RequestMapping("/manager/home/backHome")
    public String backHome( HttpSession model){
        return home();
    }

}
