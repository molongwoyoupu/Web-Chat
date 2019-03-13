package com.ssm.im.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.utils.JsonUtils;
import com.ssm.im.service.FriendGroupService;

@Controller
public class FriendGroupController {
	@Autowired
	private FriendGroupService friendGroupService;
	/**
	 * 随机创建用户的好友分组
	 */
	@RequestMapping(value = "/saveFriendGroupList")
	@ResponseBody
    public void saveFriendGroupList(){
		friendGroupService.saveFriendGroupList();
    }
	
	/**
	 *	获取用户的所有分组
	 */
	@RequestMapping(value="/getAllFriendGroupByUser",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getAllFriendGroupByUser() {
		return JsonUtils.objectToJson(friendGroupService.getAllFriendGroupByUser());
	}
	
	/**
	 *	获取用户的所有分组
	 */
	@RequestMapping(value="/getAllFriendGroupByUserId",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getAllFriendGroupByUserId(HttpServletRequest request,String userId) {
		
		return JsonUtils.objectToJson(friendGroupService.getAllFriendGroupByUserId(request,userId));
	}
}
