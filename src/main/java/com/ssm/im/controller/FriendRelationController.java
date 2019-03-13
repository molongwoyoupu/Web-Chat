package com.ssm.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.common.utils.JsonUtils;
import com.ssm.im.service.FriendRelationService;

@Controller
public class FriendRelationController {
	@Autowired
	private FriendRelationService friendRelationService;
	/**
	 * 随机创建用户的好友
	 */
	@RequestMapping(value = "/saveFriendRelationList")
	@ResponseBody
    public void saveFriendRelationList(){
		friendRelationService.saveFriendRelationList();
    }
	
	/**
	 *	获取分组的所有好友
	 */
	@RequestMapping(value="/getAllFriendRelationByGroupId",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getAllFriendRelationByGroupId(String groupId,String userId) {
		return JsonUtils.objectToJson(friendRelationService.getAllFriendByGroupId(groupId,userId));
	}
	
}
