package com.xuyu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	//转发到index页面
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	//接受页面参数
	@RequestMapping("/postIndex")
	public String postIndex(HttpServletRequest request) {
		
		String getName = request.getParameter("name");
		request.setAttribute("name", getName);
		return "forward";
	}
}
