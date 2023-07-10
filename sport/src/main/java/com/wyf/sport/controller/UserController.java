package com.wyf.sport.controller;

import com.alibaba.fastjson.JSON;
import com.wyf.sport.bean.QueryInfo;
import com.wyf.sport.bean.User;
import com.wyf.sport.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    private final String PERCENT = "%";
    @Autowired
    UserDao userDao;
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
        System.out.println("UserController.getUserList");
        // 数据个数
        int counts = userDao.getUserCounts(PERCENT+queryInfo.getQuery() + PERCENT);
        // 当前已查询到的数据个数。从下一个进行分页
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<User> userList = userDao.getAllUser(PERCENT + queryInfo.getQuery() + PERCENT,pageStart,queryInfo.getPageSize());
        HashMap<String,Object> res = new HashMap<>();
        res.put("userCounts", counts);
        res.put("data", userList);
        userList.forEach(item->{
            System.out.println("UserList: "+item.toString());
        });
        String res_json = JSON.toJSONString(res);
        return res_json;

    }
    @RequestMapping("/updateState")
    public String updateUserState(@RequestParam("id") Integer id,
                                  @RequestParam("state") Boolean state){
        System.out.println("UserController.updateUserState");
        // 是否成功
        int res = userDao.updateState(id,state);
        return res > 0 ? "success" : "error";
    }
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        System.out.println("UserController.addUser");
        user.setId(userDao.getMaxUserId() + 1);
        user.setRole("普通用户");
        user.setState(false);
        int res = userDao.addUser(user);
        return res > 0 ? "success" : "error";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        System.out.println("UserController.deleteUser");
        int deleteCount = userDao.deleteUser(id);
        return deleteCount > 0? "success" : "error";
    }
    @RequestMapping("/getUser")
    public String getUser(int id){
        System.out.println("UserController.getUser");
        User user = userDao.getUpdateUser(id);
        return JSON.toJSONString(user);
    }
    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        System.out.println("UserController.updateUser");
        System.out.println(user.toString());
        int updateCount = userDao.updateUser(user);
        return updateCount > 0? "success" : "error";
    }
}
