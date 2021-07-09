package com.yakeManager.controller;

import com.yakeManager.service.serviceInterface.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("clientController")
@RequestMapping("/raliway")
public class ClientControl {

    @Resource(name = "userServiceImpl")
    UserService userService;


    @RequestMapping("/home")
    public String backHome(){
        return "/clientPage/htmls/home";
    }
    @RequestMapping("/buyTicket")
    public String mbuyTicket(HttpSession session){
        session.setAttribute("start_station","");
        session.setAttribute("end_station","");
        session.setAttribute("time","");
        return "/clientPage/htmls/buyTicket";
    }
    @RequestMapping("/backTicket")
    public String mbackTicket(){
        return "/clientPage/htmls/backTicket";
    }
    @RequestMapping("/mine")
    public String mmine(){
        return "/clientPage/htmls/mine";
    }
    @RequestMapping("/modify")
    public String mmodify(){
        return "/clientPage/htmls/modify";
    }
    @RequestMapping("/findTicket")
    public String mfindTicket(){
        return "/clientPage/htmls/findTicket";
    }

    @RequestMapping("/go")
    public String mgotoFindTicket(){
        return "/clientPage/htmls/findTicket";
    }
    @RequestMapping("/goBuyTicket")
    public String mgoBuyTicket(@RequestParam("start_station") String strat_station,
                              @RequestParam("end_station")String end_station,
                              @RequestParam("time")String time,
                              HttpSession session){
        session.setAttribute("start_station",strat_station);
        session.setAttribute("end_station",end_station);
        session.setAttribute("time",time);
        return "/clientPage/htmls/buyTicket";
    }
    @RequestMapping("/noUser")
    public String toLogin(HttpServletResponse httpServletResponse) throws IOException {

        return "/clientPage/htmls/clientLogin";
    }
    @RequestMapping("/toRegister")
    public String toRegister(HttpServletResponse httpServletResponse)  {

        return "/clientPage/htmls/register";
    }



    @RequestMapping("/main")
    public String clientHome(){

        return "redirect:home";
    }
}
