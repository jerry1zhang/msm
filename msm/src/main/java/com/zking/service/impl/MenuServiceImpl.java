package com.zking.service.impl;

import com.zking.dao.MenuMapper;
import com.zking.pojo.Menu;
import com.zking.service.BaseService;
import com.zking.service.MenuService;
import com.zking.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("menu")
public class MenuServiceImpl implements BaseService{
    @Resource
    MenuMapper menuMapper;


    @Override
    public PageData getAllList(PageData pg) {
        return null;
    }

    @Override
    public PageData getAllPageList(PageData pg) {
        return null;
    }

    @Override
    public PageData getPartList(PageData pg) {
        int level = Integer.valueOf(pg.getString("level"));
        List<Menu> list = menuMapper.ListByLevel(level);
        pg = new PageData();
        pg.put("list",list);
        return null;
    }

    @Override
    public PageData getPartPageList(PageData pg) {
        return null;
    }

    @Override
    public boolean del(Object object) {
        return menuMapper.deleteByPrimaryKey(((Menu)object).getId())!=0;
    }

    @Override
    public boolean add(Object object) {
        return menuMapper.insertSelective(((Menu)object))!=0;
    }

    @Override
    public boolean update(Object object) {
        return menuMapper.updateByPrimaryKeySelective(((Menu)object))!=0;
    }

    @Override
    public Object select(Object object) {
        return null;
    }
}
