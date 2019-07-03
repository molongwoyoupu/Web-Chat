package com.ssm.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class PageController {
	
	@RequestMapping("/userSearchView")
	public String userSearchView() {
		return "manage/usersearch";
	}
	
	@RequestMapping("/index")
	public String indexView() {
		return "manage/index";
	}
	
	@RequestMapping("/login")
	public String showLogin(String redirect,Model model) {
		if(!StringUtils.isEmpty(redirect)) {
			model.addAttribute("redirect", redirect);
		}
		return "manage/login";
	}
}
