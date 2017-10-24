package com.zking.controller.user;

import com.zking.biz.user.UserBiz;
import com.zking.config.ConfigCode;
import com.zking.controller.base.BaseController;
import com.zking.enetity.UserBody;
import com.zking.util.MD5Util;
import org.activiti.engine.*;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.persistence.entity.UserEntityImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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
        User user = new UserEntityImpl();
        user.setId(getRequest().getParameter("username"));
        user.setFirstName(getRequest().getParameter("firstname"));
        user.setLastName(getRequest().getParameter("lastname"));
        user.setEmail(getRequest().getParameter("email"));
        user.setPassword(getRequest().getParameter("password"));

        if(!userBiz.addUser(identityService,user,getRequest().getParameter("group"))){
            getRequest().setAttribute("error_info", ConfigCode.ADD_USER_ERROR.getValue());
            return "error";
        }
        return "/user/addUser";
    }

    @RequestMapping("/addGroup")
    public String addGroup(){
        Group group = identityService.newGroup(getRequest().getParameter("groupname"));
        group.setName(getRequest().getParameter("groupname"));
        group.setType(getRequest().getParameter("type"));
        if(!userBiz.addGroup(identityService,group)){
            logger.error("||用户"+getUser().getId()+
                    "||创建组"+getRequest().getParameter("groupname")+"("+getRequest().getParameter("type")+")"+
                    "||失败");
            return "error";
        }
        logger.info("||用户"+getUser().getId()+
                "||创建组"+getRequest().getParameter("groupname")+"("+getRequest().getParameter("type")+")"+
                "||成功");
        return "/user/addGroup";
    }

    @RequestMapping("/userList")
    public String UserList(){
        int start = Integer.valueOf(getRequest().getParameter("start"))==null?0:Integer.valueOf(getRequest().getParameter("start"));
        int end = Integer.valueOf(getRequest().getParameter("end"))==null?20:Integer.valueOf(getRequest().getParameter("end"));
        List<UserBody> userBodies = userBiz.getUserList(identityService,start,end);
        if(userBodies==null){
            return "error";
        }
        getRequest().setAttribute("userBodies",userBodies);
        return "/user/userList";
    }

//    @RequestMapping("/groupList")
//    public String GroupList(){
//        if(!userBiz.addGroup(identityService)){
//            return "error";
//        }
//        return "/user/groupList";
//    }

}
