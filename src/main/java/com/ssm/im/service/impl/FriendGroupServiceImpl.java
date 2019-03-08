package com.ssm.im.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ssm.common.utils.CookieUtils;
import com.ssm.common.utils.JsonUtils;
import com.ssm.common.utils.RandomUtils;
import com.ssm.im.mapper.FriendGroupMapper;
import com.ssm.im.pojo.FriendGroup;
import com.ssm.im.service.FriendGroupService;
import com.ssm.manage.pojo.User;

@Service
public class FriendGroupServiceImpl implements FriendGroupService {

	@Autowired
	private FriendGroupMapper friendGroupMapper;
	
	@Value("${USER_TOKEN_KEY}")
	private String USER_TOKEN_KEY;
	
	@Override
	public List<FriendGroup> getAllFriendGroupByUser() {
		FriendGroup friendGroup=new FriendGroup();
		friendGroup.setUserId("1");
		return friendGroupMapper.selectByFriendGroup(friendGroup);
	}
	@Override
	public List<FriendGroup> getAllFriendGroupByUserId(HttpServletRequest request,String userId) {
		
		String token=CookieUtils.getCookieValue(request,"TT_TOKEN");
		// 根据token从session中查询用户信息
		Object json = request.getSession().getAttribute(USER_TOKEN_KEY + ":" + token);
		if (StringUtils.isEmpty(json)) {
			throw new RuntimeException("会话过期，请重新登录");
		}
		User user=JsonUtils.jsonToPojo(json.toString(), User.class);
		FriendGroup friendGroup=new FriendGroup();
		friendGroup.setUserId(user.getId()+"");
		return friendGroupMapper.selectByFriendGroup(friendGroup);
	}
	@Override
	public void saveFriendGroupList() {
		List<FriendGroup> groupList=new ArrayList<FriendGroup>();
		for (int i = 0; i < 150; i++) {
			FriendGroup friend = new FriendGroup();
			friend.setUserId(i%30+1+"");
			friend.setGroupName(RandomUtils.getRandomChar(4));
			friend.setCreateTime(new Date());
			friend.setUpdateTime(new Date());
			groupList.add(friend);
		}
		friendGroupMapper.insertFriendGroupList(groupList);
	}

}
