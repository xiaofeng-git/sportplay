package com.wyf.sport.controller;

import com.alibaba.fastjson.JSON;
import com.wyf.sport.bean.Menu;
import com.wyf.sport.dao.MenuDao;
import com.wyf.sport.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;

    @RequestMapping("/menu")
    public String getAllMenus(){
        System.out.println("MenuController.getAllMenus");
        HashMap<String, Object> data = new HashMap<>();
        List<Menu> menus =  menuDao.getMenus();
        if(menus != null && menus.size() > 0){
            data.put("menus",menus);
            menus.forEach(item->{
                System.out.println("Menu: "+item.toString());
            });
            data.put("flag",200);
        }else{
            data.put("flag",404);
        }
        String res_json = JSON.toJSONString(data);
        return res_json;
    }
}
