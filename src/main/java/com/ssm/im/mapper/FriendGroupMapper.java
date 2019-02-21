package com.ssm.im.mapper;

import java.util.List;

import com.ssm.im.pojo.FriendGroup;


public interface FriendGroupMapper {

	public Long insertFriendGroup(FriendGroup friendGroup);
	
	public int insertFriendGroupList(List<FriendGroup> friendGroupList);
	
	public List<FriendGroup> getAllFriendGroups();
	
	public List<FriendGroup> selectByFriendGroup(FriendGroup friendGroup);
}
