package com.yakeManager.controller.managerController.managerAjax;


import com.yakeManager.pojo.Client;
import com.yakeManager.pojo.User;

import com.yakeManager.service.serviceInterface.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller("loginAjax")
@RequestMapping("/login")
public class LoginAjax {

    @Resource(name = "userServiceImpl")
    UserService userService;

    @ResponseBody
    @RequestMapping("/clientLogin")
    public int clientLogin(@RequestParam(value = "client_id") String client_id,
                              @RequestParam(value = "password") String password,
                              HttpSession session)  {
        System.out.println("来自用户提交的登录申请========>");
        if(userService.hasUser(Long.parseLong(client_id)) <= 0){
            return -1;
        }
//        System.out.println(client_id+"+==="+password);

        User user=userService.findUserById(client_id);

        System.out.println(user.getPassword()+"==="+password+user.getIdentity());
//        userService.login(client_id,password)
        if (password.equals(user.getPassword())) {

//            User user=new User(Long.parseLong(client_id),password);
            Client client =new Client();
            try {
                client = userService.getClientMdg(Long.parseLong(client_id));
                System.out.println(client);


                session.setAttribute("client_id",String.valueOf(client.getClient_id()));
                session.setAttribute("client_name",client.getClient_name().toString());
                session.setAttribute("client_email",client.getClient_email().toString());
                session.setAttribute("client_ic",client.getClient_ic().toString());
                session.setAttribute("client_phone",String.valueOf(client.getClient_phone()));
                session.setAttribute("client_type",client.getClient_type());
                session.setAttribute("client_signature",client.getSignature());
                session.setAttribute("client_avator",client.getAvatar());


//            session.setAttribute("",client.getAvatar());
//            client_id= (String)  session.getAttribute("client_id");
                if(user.getIdentity().equals("管理员")) {
                    session.setAttribute("manager_id", client_id);

                    session.setAttribute("loginManager", user);
                    System.out.println("==================================================当前登录：" + session.getAttribute("manager_id")+"::"+user.getIdentity());

                }else if(user.getIdentity().equals("客户")){
                    session.setAttribute("client_id", client_id);

                    session.setAttribute("loginClient", user);
                    System.out.println("==================================================当前登录：" + session.getAttribute("client_id")+"::"+user.getIdentity());
                }
                System.out.println("====登录成功！登录者："+user.getIdentity()+"<->"+user.getClient_id());
                return 200;

            }
           catch (Exception e){
               System.out.println(e.getLocalizedMessage()+e.toString()+e.getMessage());
               return 1;
           }


        }
        else {
            System.out.println("===账号密码有误，拒绝访问！");
            return 0;
        }
    }
}
