package com.ssm.manage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssm.common.pojo.DataResult;
import com.ssm.common.pojo.ResResult;
import com.ssm.manage.pojo.User;

public interface UserService {

	public DataResult getUserList(int page,int rows);
	
	public void saveUserList();
	
	public ResResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response);
	
	public ResResult getUserByToken(String token,
			HttpServletRequest request, HttpServletResponse response);
	
	public ResResult userLogout(String token,
			HttpServletRequest request, HttpServletResponse response);
	
	public String getUserListBySearch(int page, int rows,User user);
	
	//获取当前在线用户
	public User getThisOnLineUser(HttpServletRequest request);
}
