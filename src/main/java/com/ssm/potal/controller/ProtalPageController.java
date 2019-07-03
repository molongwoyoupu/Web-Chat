package com.ssm.potal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProtalPageController {
	
	@RequestMapping("/login")
	public String showLogin(String redirect,Model model) {
		if(!StringUtils.isEmpty(redirect)) {
			model.addAttribute("redirect", redirect);
		}
		return "protal/login";
	}
	@RequestMapping("/index")
	public String indexView() {
		return "protal/index";
	}
	@RequestMapping("/index3")
	public String index3View() {
		return "manage/index";
	}
	@RequestMapping("/index2")
	public String index2(String redirect,Model model) {
		if(!StringUtils.isEmpty(redirect)) {
			model.addAttribute("redirect", redirect);
		}
		return "protal/index2";
	}
}
