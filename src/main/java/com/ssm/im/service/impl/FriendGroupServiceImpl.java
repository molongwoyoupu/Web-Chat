package com.ssm.im.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.common.utils.RandomUtils;
import com.ssm.im.mapper.FriendGroupMapper;
import com.ssm.im.pojo.FriendGroup;
import com.ssm.im.service.FriendGroupService;

@Service
public class FriendGroupServiceImpl implements FriendGroupService {

	@Autowired
	private FriendGroupMapper friendGroupMapper;
	@Override
	public List<FriendGroup> getAllFriendGroupByUser() {
		FriendGroup friendGroup=new FriendGroup();
		friendGroup.setUserId("1");
		return friendGroupMapper.selectByFriendGroup(friendGroup);
	}
	@Override
	public List<FriendGroup> getAllFriendGroupByUserId(String userId) {
		FriendGroup friendGroup=new FriendGroup();
		friendGroup.setUserId(userId);
		return friendGroupMapper.selectByFriendGroup(friendGroup);
	}
	@Override
	public void saveFriendGroupList() {
		List<FriendGroup> groupList=new ArrayList<FriendGroup>();
		for (int i = 0; i < 50; i++) {
			FriendGroup friend = new FriendGroup();
			friend.setUserId(i%10+1+"");
			friend.setGroupName(RandomUtils.getRandomChar(4));
			friend.setCreateTime(new Date());
			friend.setUpdateTime(new Date());
			groupList.add(friend);
		}
		friendGroupMapper.insertFriendGroupList(groupList);
	}

}
