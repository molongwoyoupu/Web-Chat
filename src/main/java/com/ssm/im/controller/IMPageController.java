package com.ssm.im.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IMPageController {
	
	@RequestMapping("/chat")
	public String showLogin(String redirect,Model model) {
		if(!StringUtils.isEmpty(redirect)) {
			model.addAttribute("redirect", redirect);
		}
		return "im/chat";
	}
}
