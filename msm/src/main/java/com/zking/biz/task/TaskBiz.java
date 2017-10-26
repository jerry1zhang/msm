package com.zking.biz.task;

import com.zking.biz.BaseBiz;
import org.activiti.engine.IdentityService;
import org.activiti.engine.TaskService;

import javax.servlet.http.HttpServletRequest;

public interface TaskBiz{
    boolean getTaskList(IdentityService identityService, TaskService taskService, HttpServletRequest request);
}
