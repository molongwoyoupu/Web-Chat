package com.ssm.im.mapper;

import java.util.List;

import com.ssm.im.pojo.FriendRequest;

public interface FriendRequestMapper {

	public Long insertFriendRequest(FriendRequest friendRequest);
	
	public Long insertFriendRequestList(List<FriendRequest> friendRequestList);
	
	public List<FriendRequest> getAllFriendRequests();
	
	public List<FriendRequest> selectByFriendRequest(FriendRequest friendRequest);
}
