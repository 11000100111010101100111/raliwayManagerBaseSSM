package com.yakeManager.aop;

import com.yakeManager.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class GetHttpSources {
    public GetHttpSources() {
//        userList=new ArrayList<User>(){};
    }

    public static List<User> getUserList() {
        return userList;
    }

    public static void setUserList(List<User> userList) {
        GetHttpSources.userList = userList;
    }

    static List<User> userList=new ArrayList<User>(){};

}
