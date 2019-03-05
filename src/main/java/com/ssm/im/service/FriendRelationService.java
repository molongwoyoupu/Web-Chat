package com.ssm.im.service;

import java.util.List;

import com.ssm.im.pojo.dto.FriendDto;

public interface FriendRelationService {

	public void getAllFriendByUserId();
	
	public List<FriendDto> getAllFriendByGroupId(String groupId);
	
	public void saveFriendRelationList();
}
