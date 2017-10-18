package com.zking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zking.controller.base.BaseController;
@Controller
@RequestMapping("page")
public class PageController extends BaseController{
	@RequestMapping("/menu")
	public String menu(){
		return "menu";
	}
	
	@RequestMapping("/header")
	public String header(){
		return "header";
	}
	
	@RequestMapping("/footer")
	public String footer(){
		return "footer";
	}
	
	@RequestMapping("/main")
	public String main(){
		return "body";
	}
}
