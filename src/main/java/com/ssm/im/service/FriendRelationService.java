package com.ssm.im.service;

import java.util.List;

import com.ssm.im.pojo.FriendRequest;
import com.ssm.im.pojo.dto.FriendDto;

public interface FriendRelationService {

	public void getAllFriendByUserId();
	
	public List<FriendDto> getAllFriendByGroupId(String groupId,String userId);
	
	public void saveFriendRelationList();
	
	//通过好友申请
	public void saveFriendRelation(FriendRequest friendRequest);
}
