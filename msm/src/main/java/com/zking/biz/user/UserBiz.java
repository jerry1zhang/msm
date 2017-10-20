package com.zking.biz.user;

import org.activiti.engine.IdentityService;

import javax.servlet.http.HttpServletRequest;

public interface UserBiz {
    public boolean addUser(HttpServletRequest request, IdentityService identityService);
    public boolean addGroup(HttpServletRequest request, IdentityService identityService);
    public boolean getUser(HttpServletRequest request, IdentityService identityService);
}
