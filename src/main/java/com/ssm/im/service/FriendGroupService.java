package com.ssm.im.service;

import java.util.List;

import com.ssm.im.pojo.FriendGroup;

public interface FriendGroupService {

	public List<FriendGroup> getAllFriendGroupByUser();
	
	public List<FriendGroup> getAllFriendGroupByUserId(String userId);
	
	public void saveFriendGroupList();
}