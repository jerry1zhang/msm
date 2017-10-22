package com.zking.service.impl;

import com.zking.dao.MenuMapper;
import com.zking.pojo.Menu;
import com.zking.service.MenuService;

import javax.annotation.Resource;
import java.util.List;

@Resource
public class MenuServiceImpl implements MenuService{
    MenuMapper menuMapper;
    @Override
    public List<Menu> getMenuList(int powerLevel, int level) {
        return menuMapper.ListByLevel(level);
    }

    @Override
    public boolean del(Menu menu) {
        return menuMapper.deleteByPrimaryKey(menu.getId())!=0;
    }

    @Override
    public boolean add(Menu menu) {
        return menuMapper.insertSelective(menu)!=0;
    }

    @Override
    public boolean update(Menu menu) {
        return menuMapper.updateByPrimaryKeySelective(menu)!=0;
    }
}
