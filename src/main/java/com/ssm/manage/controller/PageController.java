package com.ssm.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/userSearchView")
	public String userSearchView() {
		return "manage/usersearch";
	}
	
	@RequestMapping("/index")
	public String indexView() {
		return "protal/index";
	}
	
	@RequestMapping("/manage/login")
	public String showLogin(String redirect,Model model) {
		if(!StringUtils.isEmpty(redirect)) {
			model.addAttribute("redirect", redirect);
		}
		return "manage/login";
	}
}
