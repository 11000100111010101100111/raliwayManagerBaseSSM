package com.yakeManager.controller;

import com.alibaba.fastjson.JSON;
import com.yake.pojo.AjaxModel;
import com.yakeManager.pojo.User;
import com.yakeManager.aop.GetHttpSources;
import com.yakeManager.service.serviceInterface.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller("aOPajax")
@RequestMapping("/ajax")
public class AOPajax {
    @Resource(name = "userServiceImpl")
    UserService userService;

    @Resource(name = "managerLogin")
    User user;
    //判断用户是否已经登录
    @ResponseBody
    @RequestMapping("/notLogin")
    public AjaxModel judgeLogin(HttpSession session){
        AjaxModel ajaxModel=new AjaxModel();
        if (session.getAttribute("client_id")==null||"".equals(session.getAttribute("client_id"))){
            ajaxModel.setStatusCode(0);
        }else{
            ajaxModel.setStatusCode(1);
        }
//        User user = userService.findUserByTel(userTel);
//        if (user!=null){
//            model.setCode(400);
//            model.setMsg("该联系电话已经注册，不可重复注册！！！");
//        }else {
//            model.setCode(200);
//        }
        System.out.println("已发送："+ajaxModel.getStatusCode());
        return ajaxModel;
    }

//    @ResponseBody
//    @RequestMapping("/findlocal")
//    public AjaxModel<String> ajaxModel(){
//        AjaxModel<String > ajaxModel=new AjaxModel<String>();
//        try {
////            System.out.println("1");
//            ArrayList<String> arr=userService.findAllProvince();
////            System.out.println("ok");
//            ajaxModel.setLists(arr);
////            System.out.println("2");
//            ajaxModel.setStatusCode(1);
////            System.out.println("3");
//        }
//        catch (Exception e){
////            System.out.println("erreo");
//            ajaxModel.setStatusCode(0);
//        }
//        return ajaxModel;
//    }

    @RequestMapping(value = "/findlocal",method = RequestMethod.GET)
    @ResponseBody
    public String findlocalP(@Param("lists") String lists){
        lists= JSON.toJSONString(userService.findAllProvince());
        System.out.println(lists);
        return lists;
    }

    @RequestMapping(value = "/getSession",method = RequestMethod.GET)
    @ResponseBody
    public String getSession(@Param("id") String id,HttpSession session) {
        id=(String) session.getAttribute("client_id");
        return id == null ||id.equals("")?"1":id;
    }


    @RequestMapping(value = "/login_id",method = RequestMethod.POST)
    @ResponseBody
    public String login_id(@Param("userid") String id,HttpSession session) {
        System.out.println("1");
        return userService.findUserById(id)!=null ? "1":"0";
    }

    @RequestMapping(value = "/login_msg",method = RequestMethod.POST)
    @ResponseBody
    public String login_msg(@Param("uid") String uid,@Param("pwd")String pwd,HttpSession session) {
        String flage="0";
        if(hasUser((String)session.getAttribute("client_id"))){
//            账号为UID的用户正在处于登录状态，返回标识码2
            return "2";
        }

        if (userService.login(uid, pwd)) {
            if (session.getAttribute("loginManager") != null) {
//                    如果当前UID正在登录，先清除此用户的session
                System.out.println("===>"+getTime() +"用户退出：" + session.getAttribute("client_id") + session.getAttribute("loginManager"));

                session.removeAttribute("client_id");
                session.removeAttribute("password");
                session.removeAttribute("loginManager");
            }

//                重新将新的session保存
            session.setAttribute("client_id", uid);
            session.setAttribute("password", pwd);
            session.setAttribute("loginManager", user = new User(Long.parseLong(uid), pwd));
            GetHttpSources.getUserList().add(user);
            System.out.println("===>"+getTime() +"用户加入：" + session.getAttribute("client_id")+ session.getAttribute("loginManager"));
            flage = "1";
        }

        return flage;
    }
    public String getTime(){
        return (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format((Calendar.getInstance()).getTime()));
    }
    public boolean hasUser(String uid){
        List<User> users=GetHttpSources.getUserList();
        boolean flage=false;
        for (User item:users) {
            if(uid.equals(item.getClient_id())){
                flage=true;
                break;
            }
        }
        return flage;
    }
}
