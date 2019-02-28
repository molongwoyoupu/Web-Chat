package com.ssm.im.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.ssm.common.utils.RandomUtils;
import com.ssm.im.mapper.FriendRelationMapper;
import com.ssm.im.pojo.FriendRelation;
import com.ssm.im.pojo.dto.FriendDto;
import com.ssm.im.service.FriendRelationService;

@Service
public class FriendRelationServiceImpl implements FriendRelationService {

	@Autowired
	private FriendRelationMapper friendRelationMapper;
	@Override
	public void getAllFriendByUserId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveFriendRelationList() {
		List<FriendRelation> friendList = new ArrayList<FriendRelation>();
		for (int i = 0; i < 30; i++) {
			FriendRelation friend = new FriendRelation();
			friend.setUserId("1");;
			friend.setFriendId(i+1+"");
			friend.setFriendType("" + (int) (Math.random() * 3 + 1));
			friend.setFriendRemark(RandomUtils.getRandomChar(3));
			friend.setFriendGroupId((i)%5+1+"");
			friend.setCreateTime(new Date());
			friend.setUpdateTime(new Date());
			friendList.add(friend);
		}
		friendRelationMapper.insertFriendRelationList(friendList);
	}

	@Override
	public List<FriendDto> getAllFriendByGroupId(String groupId) {
		FriendRelation friendRelation=new FriendRelation();
		friendRelation.setFriendGroupId(groupId);
		return friendRelationMapper.selectFriendDtoByFriendRelation(friendRelation);
	}

}
