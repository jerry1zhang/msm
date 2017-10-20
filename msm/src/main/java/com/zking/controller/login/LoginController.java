package com.zking.controller.login;

import com.zking.biz.user.UserBiz;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zking.controller.base.BaseController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController{

	@Resource
	IdentityService identityService;
	@Resource
	TaskService taskService;
	@Resource
	RuntimeService runtimeService;
	@Resource
	UserBiz userBiz;

	@RequestMapping("/loginPage")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(){
		if(!userBiz.getUser(getRequest(),identityService)){
			return "admin-404";
		}
		return "admin-index";
	}

	@RequestMapping("/doTask")
	public String doTask(){
		if(getRequest().getParameterValues("taskidlist")!=null){
			String[] list = getRequest().getParameterValues("taskidlist");
			for (String e:list) {
				User user = (User)getSession().getAttribute("User");
				//创建任务
				Task task = taskService.createTaskQuery().taskId(e).singleResult();
				if(task!=null){
					taskService.complete(e);
					logger.info("用户id:"+user.getId()+"||任务编号:"+task.getId()+"||任务名:"+task.getName()+"||任务成功完成");
				}else{
					logger.debug("用户id:"+user.getId()+"任务编号:"+e+"不存在"+"||任务完成失败");
				}

			}
		}
		return "test/completeTask";
	}
}
