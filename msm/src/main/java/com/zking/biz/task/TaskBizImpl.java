package com.zking.biz.task;

import com.zking.biz.BaseBizImpl;
import org.activiti.engine.IdentityService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Repository
public class TaskBizImpl extends BaseBizImpl implements TaskBiz{
    @Override
    public boolean getTaskList(IdentityService identityService, TaskService taskService, HttpServletRequest request) {

        //查询属于HR用户组的用户
//		User userInGroup = identityService.createUserQuery().memberOfGroup("hr").singleResult();
//		Assert.notNull(userInGroup);
//		Assert.isTrue(userInGroup.getId().equals("Jonathan"));
//		//查询用户所属组
//		Group groupContainsUser = identityService.createGroupQuery().groupMember("Jonathan").singleResult();
//		Assert.notNull(groupContainsUser);
//		Assert.isTrue(groupContainsUser.getId().equals("hr"));
        //空指针用过滤器处理
        //查找用户信息
        User userinfo = identityService.createUserQuery().userId(request.getParameter("username")).singleResult();
        request.getSession().setAttribute("User",userinfo);
        //判断用户所在组
        Group groupContainsUser = identityService.createGroupQuery().groupMember(request.getParameter("username")).singleResult();
        request.getSession().setAttribute("Group",groupContainsUser);
        logger.info("用户id:"+userinfo.getId()+"||用户所属组：||ID:"+groupContainsUser.getId()+"||NAME:"+groupContainsUser.getName());
        //查找组所要处理的任务列表
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup(groupContainsUser.getId()).list();
        logger.info("用户id:"+userinfo.getId()+"||用户组要处理的任务数:"+tasks.size());
        request.setAttribute("tasks",tasks);
//		tasks.get(0).getProcessInstanceId()
//		tasks.get(0).getDescription();
//		tasks.get(0).getCreateTime()
//		tasks.get(0).getDueDate()
//		tasks.get(0).getName()
//		tasks.get(0).getOwner()
        return true;
    }
}
