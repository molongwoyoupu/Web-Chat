package com.ssm.im.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.common.pojo.ResResult;
import com.ssm.im.mapper.FriendRequestMapper;
import com.ssm.im.pojo.FriendRequest;
import com.ssm.im.service.FriendRequestService;
import com.ssm.manage.pojo.User;
import com.ssm.manage.service.UserService;
@Service
public class FriendRequestServiceImpl implements FriendRequestService {

	@Autowired
	private FriendRequestMapper friendRequestMapper;
	
	@Autowired
	private UserService userService;
	@Override
	public List<FriendRequest> getAllFriendRequestByUserId(String userId) {
		FriendRequest req=new FriendRequest();
		req.setUserId(userId);
		return friendRequestMapper.selectByFriendRequest(req);
	}

	@Override
	public void saveFriendRequestList() {
		List<FriendRequest> reqList=new ArrayList<FriendRequest>();
		for (int i = 0; i < 28; i++) {
			if(i%10+1==i) {
				continue;
			}
			FriendRequest friendReq = new FriendRequest();
			friendReq.setUserId(i%10+1+"");
			friendReq.setReqToId(i+"");
			friendReq.setReqGroupId("1");
			friendReq.setReqType("0");
			friendReq.setCreateTime(new Date());
			friendReq.setUpdateTime(new Date());
			reqList.add(friendReq);
		}
		friendRequestMapper.insertFriendRequestList(reqList);
		
	}

	@Override
	public List<FriendRequest> getAllFriendRequestByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResResult sendFriendRequest(HttpServletRequest request, FriendRequest friendReq) {
		User user=userService.getThisOnLineUser(request);
		friendReq.setCreateTime(new Date());
		friendReq.setUpdateTime(new Date());
		friendReq.setReqType("0");
		friendReq.setUserId(user.getId()+"");
		Long count=friendRequestMapper.insertFriendRequest(friendReq);
		if(count>0) {
			return ResResult.ok("申请成功");
		}
		return ResResult.build(211,"申请失败");
	}

}
