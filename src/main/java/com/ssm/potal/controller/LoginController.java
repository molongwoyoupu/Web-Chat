package com.ssm.potal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.pojo.ResResult;
import com.ssm.common.utils.ExceptionUtil;
import com.ssm.manage.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token,String callback,
			HttpServletRequest request, HttpServletResponse response) {
		ResResult result = null;
		try {
			result = userService.getUserByToken(token,request,  response);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		//判断是否为jsonp调用
		if (!StringUtils.isEmpty(callback)) {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			return mappingJacksonValue;
		}
		return result;
	}
	
	/**
	 *	登录处理   
	 */
	@RequestMapping("/dologin")
	@ResponseBody
	public ResResult doLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		ResResult result = userService.userLogin(username, password, request, response);
		return result;
	}
	
	
	//退出登录
	@RequestMapping("/logout/{token}")
	@ResponseBody
	public Object userLogout(@PathVariable String token, String callback,
			HttpServletRequest request, HttpServletResponse response) {
		ResResult result = null;
		try {
			result = userService.userLogout(token,request,response);
		} catch (Exception e) {
			e.printStackTrace();
			result = ResResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		

		if (StringUtils.isEmpty(callback)) {
			return result;
		} else {
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(
					result);
			return mappingJacksonValue;
		}
	}

}
