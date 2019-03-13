package com.ssm.im.mapper;

import java.util.List;

import com.ssm.im.pojo.FriendRequest;
import com.ssm.im.pojo.dto.FriendRequestDto;

public interface FriendRequestMapper {

	public FriendRequest findById(Long id);
	
	public Long insertFriendRequest(FriendRequest friendRequest);
	
	public Long insertFriendRequestList(List<FriendRequest> friendRequestList);
	
	public List<FriendRequest> getAllFriendRequests();
	
	public List<FriendRequestDto> selectByFriendRequest(FriendRequest friendRequest);

	public Long updateFriendRequest(FriendRequest friendRequest);
	
}
