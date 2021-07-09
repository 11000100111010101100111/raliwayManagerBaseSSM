package com.yakeManager.controller.managerController;

import com.yakeManager.pojo.User;
import com.yakeManager.service.serviceInterface.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@Controller("manager")
@RequestMapping("/manager")
public class Manager {
    @Resource(name = "managerLogin")
    User user;

    @Resource(name = "userServiceImpl")
    UserService userService;


//    进行列车管理
    @RequestMapping("/ral")
    public String mRailwayOperations(HttpSession httpSession, HttpServletResponse hsr){
        try {
            ArrayList<String> privonces = userService.findAllProvince();
            httpSession.setAttribute("provinces", privonces);
        }
        catch (Exception e){
            System.out.println("查询失败！");
        }
        return "/managerPage/raliway";
    }

//    进入铁路运维,包括增加火车站、增加火车，增加列车车次
    @RequestMapping("/station")
    public String mStationOperations( HttpSession model, HttpServletResponse hsr){

        try{
            System.out.println("#"+model.getAttribute("client_id")+":执行操作：铁路运维");

            ArrayList<String> pros=userService.findAllProvince();
            System.out.println(pros);
            model.setAttribute("provinces",pros);

            ArrayList<String> trains=userService.findTrainType();
            System.out.println(trains);
            model.setAttribute("traintypes",trains);

            ArrayList<String> chiose_stations=userService.findstation();
            System.out.println(chiose_stations);
            model.setAttribute("chiose_stations",chiose_stations);

            ArrayList<String> chiose_raliways=userService.findstation();
            System.out.println(chiose_raliways);
            model.setAttribute("chiose_raliways",chiose_raliways);

//            ArrayList<String> trainCode=new ArrayList<String>();
//            for (int i=0;i<trainCode.size();i++){
//                trainCode.add(trains.get(i).substring(trains.get(i).length()-2,trains.get(i).length()-1));
//            }
//            model.setAttribute("train_code",trainCode);
        }

        catch (Exception i){System.out.println("异常");}

        return "/managerPage/raliway";
    }

//    跳转到客户管理页
    @RequestMapping("/client")
    public String mClientManager( HttpSession model, HttpServletResponse hsr){

        try{System.out.println("#"+model.getAttribute("client_id")+"执行操作：客户管理");}
        catch (Exception i){System.out.println("异常");}
        return "/managerPage/client";
    }

//    跳转到人事管理页面
    @RequestMapping("/personnel")
    public String mPersonnel( HttpSession model, HttpServletResponse hsr){

        try{System.out.println("#"+model.getAttribute("client_id")+"执行操作：人事管理");}
        catch (Exception i){System.out.println("异常");}

        return "/managerPage/personnel";
    }

    //去我的信息页
    @RequestMapping("/mine")
    public String mMine( HttpSession model, HttpServletResponse hsr){

        try{System.out.println("#"+model.getAttribute("client_id")+"执行操作：我的主页");}
        catch (Exception i){System.out.println("异常");}

        return "/managerPage/mine";
    }

    @RequestMapping("/noUser")
    public String toLogin(HttpServletResponse httpServletResponse) throws IOException {
//        httpServletResponse.setCharacterEncoding("utf-8");
////        String msg=new String("<script>alert('没有登录信息!去登录');</script>".getBytes("utf-8"),"utf-8");
//        httpServletResponse.getWriter().write("<script type=\"text/javascript\">alert('没有登录信息!去登录');</script>");
        return "/managerPage/login";
    }

    //进入列车大厅按时间查看所有列车状态
    @RequestMapping("/Railways")
    public String managerRaliway(){
        return "/managerPage/station";
    }
    @RequestMapping("/noManager")
    public String noManager(HttpServletResponse httpServletResponse) throws IOException {
        return "/managerPage/login";
    }
}
