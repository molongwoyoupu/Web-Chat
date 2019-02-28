package com.ssm.im.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
