package com.wyf.sport.controller;

import com.alibaba.fastjson.JSON;
import com.wyf.sport.bean.User;
import com.wyf.sport.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserDao userdao;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        System.out.println("LoginController.login");
        String flag = "error";
        String res_json = "";
        // 调用dao获取db中登录user
        User us = userdao.getUserByMessage(user.getUsername(),user.getPassword());
        if(us != null && us.getId() >= 0){
            flag = "ok";
            System.out.println("user:"+ us.toString());
            // json使用
            HashMap<String, Object> res = new HashMap<String,Object>();
            res.put("flag",flag);
            res.put("user",us);
            res_json = JSON.toJSONString(res);
        }
        return res_json;
    }
}
