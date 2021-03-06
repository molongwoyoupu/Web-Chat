package com.ssm.im.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.pojo.ResResult;
import com.ssm.common.utils.JsonUtils;
import com.ssm.im.pojo.FriendRequest;
import com.ssm.im.service.FriendRequestService;

@Controller
public class FriendRequestController {
	@Autowired
	private FriendRequestService friendRequestService;
	/**
	 * 随机创建用户的好友添加请求
	 */
	@RequestMapping(value = "/saveFriendRequestList")
	@ResponseBody
    public void saveFriendRequestList(){
		friendRequestService.saveFriendRequestList();
    }
	
	/**
	 *	获取用户的所有好友添加请求
	 */
	@RequestMapping(value="/getAllFriendRequestByUser",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getAllFriendRequestByUser() {
		return JsonUtils.objectToJson(friendRequestService.getAllFriendRequestByUser());
	}
	
	/**
	 *	获取用户的所有好友添加请求
	 */
	@RequestMapping(value="/getFriendRequestListByUser",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getFriendRequestListByUser(FriendRequest friendReq) {
		return JsonUtils.objectToJson(friendRequestService.getFriendRequestListByUser(friendReq));
	}
	
	/**
	 *	发送好友添加请求
	 */
	@RequestMapping(value="/sendFriendRequest",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public ResResult sendFriendRequest(HttpServletRequest request,FriendRequest friendReq) {
		return friendRequestService.saveFriendRequest(request,friendReq);
	}
	
	/**
	 *	回应好友添加请求（同意、拒绝、忽略）
	 */
	@RequestMapping(value="/applyFriendRequest",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public ResResult applyFriendRequest(HttpServletRequest request,FriendRequest friendReq) {
		return friendRequestService.updateFriendRequest(request,friendReq);
	}
}
