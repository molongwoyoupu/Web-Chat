package com.ssm.im.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ssm.im.pojo.FriendGroup;

public interface FriendGroupService {

	public List<FriendGroup> getAllFriendGroupByUser();
	
	public List<FriendGroup> getAllFriendGroupByUserId(HttpServletRequest request,String userId);
	
	public void saveFriendGroupList();
}
