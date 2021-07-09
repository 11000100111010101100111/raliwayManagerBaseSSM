package com.yakeManager.controller.managerController.managerAjax;

import com.yakeManager.pojo.AjaxModel;
import com.yakeManager.pojo.ClientTicket;
import com.yakeManager.service.serviceInterface.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller("backTicketAjax")
@RequestMapping("/backTicket")
public class BackTicketAjax {

    @Resource(name = "userServiceImpl")
    UserService userService;

    @ResponseBody
    @RequestMapping("/findAllTicketAboutClient")
    public ArrayList<ClientTicket> findAllTicketAboutClient(@RequestParam("client_id")String client_id, HttpSession session){

        System.out.println("===========>>>>>>>"+client_id);
        System.out.println("=====>开始查询"+session.getAttribute("client_id")+"的所有车票信息....");
        ArrayList<ClientTicket> tickets=new ArrayList<ClientTicket>();
        try {
            tickets = userService.findClientTicket(session.getAttribute("client_id").toString());

            for (ClientTicket ck:tickets){
                if(!ck.getTicket_state().equals("正常")){
                    ck.setSeat_type("未失效");
                }else{
                    ck.setTicket_state("已"+ck.getTicket_state());
                }
            }

            System.out.println(tickets);
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return tickets;
    }
    @ResponseBody
    @RequestMapping("/returnSession")
    public AjaxModel<String> findAllTicketAboutClient(HttpSession session){


        System.out.println("=====>开始查询"+session.getAttribute("client_id")+"的session....");

        AjaxModel<String> srr = new AjaxModel<String>();
        try {
            String client_id= (String) session.getAttribute("client_id");

            System.out.println(client_id);

            srr.setValue(client_id);
            srr.setFalge(200);
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
            srr.setFalge(0);
        }
        return srr;
    }

    @ResponseBody
    @RequestMapping("/modifyAndDelete")
    public int modifyAndDelete(@RequestParam("ticket_id")String ticket_id, HttpSession session){
        System.out.println("====>用户："+session.getAttribute("client_id")+",正在退票：票编号"+ticket_id);
//        return userService.backetTicket("退票", Long.parseLong( ticket_id) );
        System.out.println(userService.backetTicket("退票", Long.parseLong( ticket_id) ));
        return 1;
    }
}
