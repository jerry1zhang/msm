package com.zking.controller.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zking.biz.user.UserBiz;
import com.zking.config.KeyConfig;
import com.zking.controller.base.BaseController;
import org.activiti.engine.IdentityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/apiuser")
public class UserApiController extends BaseController{

    @Resource
    UserBiz userBiz;
    @Resource
    IdentityService identityService;

    @RequestMapping(value="/userList" ,method= RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object userList(Model model){
        int page = Integer.valueOf(getRequest().getParameter("page"));
        userBiz.getUserList(identityService,(page-1)* KeyConfig.pagenum,page*KeyConfig.pagenum);
        int totalData = Integer.valueOf(String.valueOf(identityService.createUserQuery().count()));
        int showData = KeyConfig.pagenum;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("totalData",totalData);
        jsonObject.addProperty("showData",showData);
        return new Gson().toJson(jsonObject);
    }
}
