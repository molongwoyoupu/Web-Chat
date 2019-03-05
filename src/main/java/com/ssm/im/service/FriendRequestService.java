package com.ssm.im.service;

import java.util.List;

import com.ssm.im.pojo.FriendRequest;
import com.ssm.im.pojo.FriendRequest;

public interface FriendRequestService {
	public List<FriendRequest> getAllFriendRequestByUser();
	
	public List<FriendRequest> getAllFriendRequestByUserId(String userId);
	
	public void saveFriendRequestList();
}
