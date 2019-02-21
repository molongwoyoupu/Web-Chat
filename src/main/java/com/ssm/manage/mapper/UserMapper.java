package com.ssm.manage.mapper;

import java.util.List;

import com.ssm.manage.pojo.User;

public interface UserMapper {

	public Long insertUser(User user);
	
	public int insertUserList(List<User> userList);
	
	public List<User> getAllUsers();
	
	public List<User> selectByUser(User user);
	
}
