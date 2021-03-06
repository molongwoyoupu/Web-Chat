package com.ssm.im.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.common.utils.RandomUtils;
import com.ssm.im.mapper.FriendRelationMapper;
import com.ssm.im.pojo.FriendRelation;
import com.ssm.im.pojo.FriendRequest;
import com.ssm.im.pojo.dto.FriendDto;
import com.ssm.im.service.FriendRelationService;

@Service
public class FriendRelationServiceImpl implements FriendRelationService {

	@Autowired
	private FriendRelationMapper friendRelationMapper;
	@Override
	public void getAllFriendByUserId() {
		
	}

	@Override
	public void saveFriendRelationList() {
		List<FriendRelation> friendList = new ArrayList<FriendRelation>();
		for(int i = 0; i < 30; i++){
			for (int j = 0; j < 30; j++) {
				FriendRelation friend = new FriendRelation();
				String me=i+1+"";
				friend.setUserId(me);
				if(me.equals(j+1+"")) {
					continue;
				}
				friend.setFriendId(j+1+"");
				friend.setFriendType( (int) (Math.random() * 3 + 1)+"");
				friend.setFriendRemark(RandomUtils.getRandomChar(3));
				friend.setFriendGroupId(((int)(Math.random() * 5))*30+i+1+"");
				friend.setCreateTime(new Date());
				friend.setUpdateTime(new Date());
				friendList.add(friend);
			}
		}
		friendRelationMapper.insertFriendRelationList(friendList);
	}

	@Override
	public List<FriendDto> getAllFriendByGroupId(String groupId,String userId) {
		FriendRelation friendRelation=new FriendRelation();
		friendRelation.setFriendGroupId(groupId);
		friendRelation.setUserId(userId);
		return friendRelationMapper.selectFriendDtoByFriendRelation(friendRelation);
	}

	@Override
	public void saveFriendRelation(FriendRequest friendRequest) {
		List<FriendRelation> friendList = new ArrayList<FriendRelation>();
		FriendRelation friend = new FriendRelation();
		friend.setUserId(friendRequest.getUserId());
		friend.setFriendId(friendRequest.getReqToId());
		friend.setFriendType("1");
		friend.setFriendGroupId(friendRequest.getReqGroupId());
		friend.setCreateTime(new Date());
		friend.setUpdateTime(new Date());
		friendList.add(friend);
		FriendRelation friend2 = new FriendRelation();

		friend2.setFriendType("1");
		friend2.setCreateTime(new Date());
		friend2.setUpdateTime(new Date());
		
		friend2.setUserId(friendRequest.getReqToId());
		friend2.setFriendId(friendRequest.getUserId());
		friend2.setFriendGroupId("defualt1");
		friendList.add(friend2);
		friendRelationMapper.insertFriendRelationList(friendList);
	}

}
