package com.zking.service;

import com.zking.pojo.Menu;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface MenuService {
    /**
     * 获得菜单列表
     * @param powerLevel
     * @param level
     * @return
     */
    public List<Menu> getMenuList(int powerLevel,int level);

    /**
     * 删除菜单
     * @param menu
     * @return
     */
    public boolean del(Menu menu);

    /**
     * 增加菜单
     * @param menu
     * @return
     */
    public boolean add(Menu menu);

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    public boolean update(Menu menu);
}
