package com.zking.biz.user;

import com.zking.biz.BaseBiz;
import com.zking.biz.user.UserBiz;
import com.zking.config.ConfigCode;
import com.zking.util.MD5Util;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserBizImpl extends BaseBiz implements UserBiz{

    @Override
    public boolean addUser(HttpServletRequest request, IdentityService identityService) {
        //新建用户
        if(request.getParameter("username")!=null){
            User user = identityService.newUser(request.getParameter("username"));
            user.setFirstName(request.getParameter("firstname"));
            user.setLastName(request.getParameter("lastname"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(MD5Util.MD5Encode(request.getParameter("password")));
            identityService.saveUser(user);
            identityService.createMembership(request.getParameter("username"),request.getParameter("group"));
        }
        //查询现有组和用户
        List<Group> groupList = identityService.createGroupQuery().list();
        request.setAttribute("grouplist",groupList);
        List<User> userList = identityService.createUserQuery().list();
        request.setAttribute("userlist",userList);
        return true;
    }

    @Override
    public boolean addGroup(HttpServletRequest request, IdentityService identityService) {
        //新建组
        if(request.getParameter("groupname")!=null) {
            Group group = identityService.newGroup(request.getParameter("groupname"));
            group.setName(request.getParameter("groupname"));
            group.setType(request.getParameter("grouptype"));
            identityService.saveGroup(group);
        }
        //查询现有组
        List<Group> groupList = identityService.createGroupQuery().list();
        request.setAttribute("grouplist",groupList);
        return true;
    }

    @Override
    public boolean getUser(HttpServletRequest request, IdentityService identityService) {
        //查找用户信息
        User userinfo = identityService.createUserQuery().userId(request.getParameter("username")).singleResult();
        if(userinfo.getPassword().equals(MD5Util.MD5Encode(request.getParameter("password")))) {
            request.getSession().setAttribute("User", userinfo);
            //判断用户所在组
            Group groupContainsUser = identityService.createGroupQuery().groupMember(request.getParameter("username")).singleResult();
            request.getSession().setAttribute("Group", groupContainsUser);
            logger.info("用户id:" + userinfo.getId() + "||用户所属组：||ID:" + groupContainsUser.getId() + "||NAME:" + groupContainsUser.getName()+"||登陆");
        }else {
            request.setAttribute("error_info", ConfigCode.user_error_1);
            logger.info("用户id:"+request.getParameter("username")+"||错误信息:"+ConfigCode.user_error_1);
            return false;
        }
        return true;
    }
}
