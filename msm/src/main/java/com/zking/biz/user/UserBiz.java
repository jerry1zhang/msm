package com.zking.biz.user;

import com.zking.enetity.UserBody;
import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserBiz {
    public boolean addUser(IdentityService identityService, User user,String groupId);
    public boolean addGroup(IdentityService identityService,Group group);
    public UserBody getUser(IdentityService identityService,User user);
    public List<UserBody> getUserList(IdentityService identityService, int start, int end);
    public List<Group> getGroupList(IdentityService identityService, int start, int end);
}
