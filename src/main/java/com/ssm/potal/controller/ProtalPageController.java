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
	
	@RequestMapping("/index2")
	public String index2(String redirect,Model model) {
		if(!StringUtils.isEmpty(redirect)) {
			model.addAttribute("redirect", redirect);
		}
		return "protal/index2";
	}
}
