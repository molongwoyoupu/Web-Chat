package com.ssm.im.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.common.pojo.ResResult;
import com.ssm.im.mapper.FriendRequestMapper;
import com.ssm.im.pojo.FriendRequest;
import com.ssm.im.pojo.dto.FriendRequestDto;
import com.ssm.im.service.FriendRelationService;
import com.ssm.im.service.FriendRequestService;
import com.ssm.manage.pojo.User;
import com.ssm.manage.service.UserService;
@Service
public class FriendRequestServiceImpl implements FriendRequestService {

	@Autowired
	private FriendRequestMapper friendRequestMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FriendRelationService friendRelationService;
	@Override
	public List<FriendRequestDto> getAllFriendRequestByUserId(String userId) {
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
			friendReq.setUserId(2+"");
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
	public List<FriendRequestDto> getAllFriendRequestByUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResResult saveFriendRequest(HttpServletRequest request, FriendRequest friendReq) {
		User user=userService.getThisOnLineUser(request);
		friendReq.setCreateTime(new Date());
		friendReq.setUpdateTime(new Date());
		friendReq.setReqType("0");
		friendReq.setReqResult("0");
		friendReq.setUserId(user.getId()+"");
		Long count=friendRequestMapper.insertFriendRequest(friendReq);
		if(count>0) {
			return ResResult.ok("申请成功");
		}
		return ResResult.build(211,"申请失败");
	}

	@Override
	public ResResult updateFriendRequest(HttpServletRequest request, FriendRequest friendReq) {
		User user=userService.getThisOnLineUser(request);
		if(user==null) {
			return ResResult.build(211,"登录失效");
		}
		if(friendReq==null||friendReq.getId()==null) {
			return ResResult.build(211,"数据错误");
		}
		FriendRequest search=friendRequestMapper.findById(friendReq.getId());
		if(search==null) {
			return ResResult.build(211,"数据错误");
		}
		if(!search.getReqToId().equals(user.getId()+"")) {
			return ResResult.build(211,"无操作权限");
		}
		friendReq.setUpdateTime(new Date());
		Long count=friendRequestMapper.updateFriendRequest(friendReq);
		if(count>0) {
			if(friendReq.getReqResult().equals("1")) {//同意
				search.setReqResult("1");
				friendRelationService.saveFriendRelation(search);
			}
			return ResResult.ok("回应成功");
		}
		return ResResult.build(211,"回应失败");
	}

	@Override
	public List<FriendRequestDto> getFriendRequestListByUser(FriendRequest friendReq) {
		// 查询之前,配置分页
		PageHelper.startPage(friendReq.getPage(), friendReq.getRows());
		// 进行查询
		List<FriendRequestDto> list = friendRequestMapper.selectByFriendRequest(friendReq);
		
		// 返回结果
		return list;
	}

}
