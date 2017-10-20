package com.zking.controller.user;

import com.zking.biz.user.UserBiz;
import com.zking.controller.base.BaseController;
import org.activiti.engine.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
@Controller
@RequestMapping("/user")
public class UserPageController extends BaseController{
    @Resource
    RepositoryService repositoryService;
    @Resource
    TaskService taskService;
    @Resource
    IdentityService identityService;
    @Resource
    RuntimeService runtimeService;
    @Resource
    HistoryService historyService;

    @Resource
    UserBiz userBiz;
    @RequestMapping("/addUser")
    public String addUser(){
        if(!userBiz.addUser(getRequest(),identityService)){
            return "error";
        }
        return "/user/addUser";
    }

    @RequestMapping("/addGroup")
    public String addGroup(){
        if(!userBiz.addGroup(getRequest(),identityService)){
            return "error";
        }
        return "/user/addGroup";
    }
}
