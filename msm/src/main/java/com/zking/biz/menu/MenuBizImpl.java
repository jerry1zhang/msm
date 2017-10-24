package com.zking.biz.menu;

import com.zking.biz.BaseBiz;
import com.zking.config.ConfigCode;
import com.zking.enetity.MenuBody;
import com.zking.pojo.Menu;
import com.zking.service.MenuService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MenuBizImpl extends BaseBiz implements MenuBiz{

    @Resource
    MenuService menuService;

    @Override
    public List<MenuBody> initMenu(int powerLevel) {
        List<Menu> one = menuService.getMenuList(powerLevel,Integer.valueOf(ConfigCode.LEVEL_BIGMENU.getValue()));
        List<Menu> two = menuService.getMenuList(powerLevel,Integer.valueOf(ConfigCode.LEVEL_SMALLMENU.getValue()));
        if (one==null || two == null) {
            return null;
        }
        List<MenuBody> list = new ArrayList<>();
        List<Menu> smallMenu;
        MenuBody menuBody;
        for (Menu e:one ) {
            smallMenu = new ArrayList<>();
            menuBody = new MenuBody();
            menuBody.setBigMenu(e);
            for (Menu e2: two) {
                if(e.getId()==e2.getUp()){
                    smallMenu.add(e2);
                }
            }
            menuBody.setSmallMenu(smallMenu);
            list.add(menuBody);
        }
        return list;
    }
}
