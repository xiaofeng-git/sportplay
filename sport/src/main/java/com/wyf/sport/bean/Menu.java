package com.wyf.sport.bean;

import java.util.List;

// 左侧导航菜单
public class Menu {
    private int id;
    private String title;
    private String path;
    private List<SubMenu> sList;

    public int getId() {
        return id;
    }

    public Menu() {
    }

    public Menu(int id, String title, String path, List<SubMenu> sList) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.sList = sList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SubMenu> getsList() {
        return sList;
    }

    public void setsList(List<SubMenu> sList) {
        this.sList = sList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", sList=" + sList +
                '}';
    }
}
