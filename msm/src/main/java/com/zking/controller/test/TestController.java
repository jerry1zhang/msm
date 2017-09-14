package com.zking.controller.test;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
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
		return "qianjsp/index";
	}
	@RequestMapping(value="/2" ,method=RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public Object test(HttpServletRequest req) throws UnsupportedEncodingException{
		Gson json = new Gson();
		return json;
	}
}
