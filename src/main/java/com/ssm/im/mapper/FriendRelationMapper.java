package com.ssm.im.mapper;

import java.util.List;

import com.ssm.im.pojo.FriendRelation;

public interface FriendRelationMapper {

	public Long insertFriendRelation(FriendRelation friendRelation);
	
	public Long insertFriendRelationList(List<FriendRelation> friendRelationList);
	
	public List<FriendRelation> getAllFriendRelations();
	
	public List<FriendRelation> selectByFriendRelation(FriendRelation friendRelation);
}
