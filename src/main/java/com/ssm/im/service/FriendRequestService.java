package com.ssm.im.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ssm.common.pojo.ResResult;
import com.ssm.im.pojo.FriendRequest;
import com.ssm.im.pojo.dto.FriendRequestDto;

public interface FriendRequestService {
	public List<FriendRequestDto> getAllFriendRequestByUser();
	
	public List<FriendRequestDto> getAllFriendRequestByUserId(String userId);
	
	public List<FriendRequestDto> getFriendRequestListByUser(FriendRequest friendReq);
	
	public void saveFriendRequestList();
	
	public ResResult saveFriendRequest(HttpServletRequest request,FriendRequest friendReq);
	
	public ResResult updateFriendRequest(HttpServletRequest request,FriendRequest friendReq);
}
