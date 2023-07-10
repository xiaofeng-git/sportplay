package com.wyf.sport.dao;

import com.wyf.sport.bean.Menu;
import com.wyf.sport.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<Menu> getMenus();
}
