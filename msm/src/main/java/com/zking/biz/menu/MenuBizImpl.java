package com.zking.biz.menu;

import com.zking.biz.BaseBiz;
import com.zking.pojo.Menu;
import com.zking.service.MenuService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuBizImpl extends BaseBiz implements MenuBiz{

    @Resource
    MenuService menuService;

    @Override
    public Map<String, Object> initMenu(int powerLevel) {
        Map<String,Object> list = new HashMap<>();
        List<Menu> one = menuService.getMenuList(0,1);
        List<Menu> two = menuService.getMenuList(0,2);
        if (one==null || two == null) {
            return null;
        }

        list.put("one",one);
        list.put("two",two);
        return list;
    }
}
