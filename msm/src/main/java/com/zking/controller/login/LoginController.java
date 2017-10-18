package com.zking.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zking.controller.base.BaseController;

@Controller
@RequestMapping("login")
public class LoginController extends BaseController{
	@RequestMapping("/loginPage")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(){
		//TODO 做登陆信息保存
		return "main";
	}
}
