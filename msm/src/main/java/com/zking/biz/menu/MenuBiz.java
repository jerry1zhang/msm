package com.zking.biz.menu;

import javax.annotation.Resource;
import java.util.Map;
@Resource()
public interface MenuBiz {
    /**
     * 初始化菜单
     * @return
     */
    public Map<String,Object> initMenu(int powerLevel);



}
