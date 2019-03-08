package com.ssm.im.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ssm.common.pojo.ResResult;
import com.ssm.im.pojo.FriendRequest;

public interface FriendRequestService {
	public List<FriendRequest> getAllFriendRequestByUser();
	
	public List<FriendRequest> getAllFriendRequestByUserId(String userId);
	
	public void saveFriendRequestList();
	
	public ResResult sendFriendRequest(HttpServletRequest request,FriendRequest friendReq);
}
