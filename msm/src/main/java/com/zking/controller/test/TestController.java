package com.zking.controller.test;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zking.controller.base.BaseController;

@Controller
@RequestMapping("test")
public class TestController extends BaseController{
	@RequestMapping("/1")
	public String index(){
		return "login";
	}
	@RequestMapping(value="/2" ,method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public Object test(HttpServletRequest req) throws UnsupportedEncodingException{
		Gson json = new Gson();
		return json;
	}																																																																																																																	
	
	//@Test //
	public void ctables(){

		//表不存在的话创建表
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
		.buildProcessEngine();
	
		System.out.println("------processEngine:" + processEngine);
	
		//创建流程
		Deployment deployment = processEngine.getRepositoryService().createDeployment().name("入库操作")
		.addClasspathResource("diagrams/test.bpmn").addClasspathResource("diagrams/test.png").deploy();
	
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());


	}
	
	//@Test  
	public void startProcessInstance(){  
	    String processInstanceKey = "myProcess";  
	    ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
		.buildProcessEngine();
	    ProcessInstance pi = processEngine.getRuntimeService()  
	                        .startProcessInstanceByKey(processInstanceKey);  
	    System.out.println("流程实例id：" + pi.getId());  //流程实例id  101  
	    System.out.println("流程定义id：" + pi.getProcessDefinitionId());   //流程定义ID helloworld:1:4  
	}  
	
	@Test  
    public void findMyTaskInfo(){  
        String assignee = "采购";  
      //表不存在的话创建表
		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
		.buildProcessEngine();
        List<Task> listTask = processEngine.getTaskService()  
            .createTaskQuery()  
            .taskAssignee(assignee)  
            .list();  
          
        if (listTask!= null && listTask.size() >0) {  
            for (Task task : listTask) {  
            	
                System.out.println("任务ID：" + task.getId());  
                System.out.println("任务名称：" + task.getName());  
                System.out.println("任务时间：" + task.getCreateTime());  
                System.out.println("任务的班里人：" + task.getAssignee());  
                System.out.println("任务的实例ID：" + task.getProcessDefinitionId());  
                System.out.println("执行对象的ID：" + task.getExecutionId());  
                System.out.println("任务的班里人：" + task.getAssignee());  
                System.out.println("流程定义ID：" + task.getProcessInstanceId());  
            }  
        }  
              
          
    }  
    
    //@Test  
    public void createUserAndGroup() {
    	ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
		.buildProcessEngine();
    	IdentityService identityService = processEngine.getIdentityService();//认证：保存组和用户信息 
    	Group group = identityService.newGroup("采购");
    	identityService.saveGroup(group);//建立组 
//    	identityService.saveGroup(new GroupEntity("总经理"));//建立组 
    	User user = identityService.newUser("小王");
    	identityService.saveUser(user);//建立用户 
//    	identityService.saveUser(new UserEntity("小李")); //建立用户 
//    	identityService.saveUser(new UserEntity("小王")); //建立用户 
    	identityService.createMembership("小王", "采购");//建立组和用户关系 
//    	identityService.createMembership("小李", "部门经理");//建立组和用户关系 
//    	identityService.createMembership(“小王”, “总经理”);//建立组和用户关系
    }
}
