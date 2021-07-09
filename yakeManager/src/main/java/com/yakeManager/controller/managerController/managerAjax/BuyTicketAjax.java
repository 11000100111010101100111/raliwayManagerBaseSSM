package com.yakeManager.controller.managerController.managerAjax;

import com.yakeManager.pojo.AjaxModel;
import com.yakeManager.pojo.Ticket;
import com.yakeManager.service.serviceInterface.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Controller("buyTicketAjax")
@RequestMapping("/buyTicket")
public class BuyTicketAjax {

    @Resource(name = "userServiceImpl")
    UserService userService;

    @ResponseBody
    @RequestMapping("/findTicket")
    public String findTicket(HttpSession session,
                            @RequestParam("start_point") String start_point,
                             @RequestParam("end_point") String end_point,
                             @RequestParam("time") String time) throws ParseException {
        System.out.println("====>"+session.getAttribute("")+"用户进入查票:");
        String tab="<tr><td>G2223</td><td>南昌西</td><td class='exe-td'><div><p >2020-7-1&nbsp;&nbsp;12:00:00</p><p >北京西站</p></div></td><td class='exe-td'><div><p >"+
                "2021-7-1&nbsp;&nbsp;</p><p >10</p></div></td><td>10</td><td>10</td><td>10</td><td>10</td><td>10</td><td>"+
                "10</td><td><a href='#' onclick='click_a(1)'>10</a></td></tr>";
        AjaxModel<String> t=new AjaxModel<String>();
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add(tab);

        t.setFalge(200);
        t.setList(arrayList);

        System.out.println(t.getList().size()+"="+t.getList().get(1));
        return tab;
    }


}
