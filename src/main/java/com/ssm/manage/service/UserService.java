package com.ssm.manage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.common.pojo.DataResult;
import com.ssm.common.pojo.ResResult;
import com.ssm.manage.pojo.User;

public interface UserService {

	DataResult getUserList(int page,int rows);
	
	void saveUserList();
	
	ResResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response);
	
	ResResult getUserByToken(String token,
			HttpServletRequest request, HttpServletResponse response);
	
	ResResult userLogout(String token,
			HttpServletRequest request, HttpServletResponse response);
	
	String getUserListBySearch(int page, int rows,User user);
	
	//获取当前在线用户
	User getThisOnLineUser(HttpServletRequest request);
}
