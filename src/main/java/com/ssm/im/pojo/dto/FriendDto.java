package com.ssm.im.pojo.dto;

import java.io.Serializable;
import java.util.Date;

public class FriendDto implements Serializable{

	private static final long serialVersionUID = 2818667557512689375L;
	private Long id;
	private String userId;
	private String friendId;
	private String friendType;
	private String friendRemark;
	
	private String friendGroupId;
	private Date createTime;
	private Date updateTime;
	private Boolean availability=true;
	
	private String friendAccountNum;
	private String friendNickName;
	private String friendHeadPath;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getFriendType() {
		return friendType;
	}
	public void setFriendType(String friendType) {
		this.friendType = friendType;
	}
	public String getFriendRemark() {
		return friendRemark;
	}
	public void setFriendRemark(String friendRemark) {
		this.friendRemark = friendRemark;
	}
	public String getFriendGroupId() {
		return friendGroupId;
	}
	public void setFriendGroupId(String friendGroupId) {
		this.friendGroupId = friendGroupId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Boolean getAvailability() {
		return availability;
	}
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	public String getFriendAccountNum() {
		return friendAccountNum;
	}
	public void setFriendAccountNum(String friendAccountNum) {
		this.friendAccountNum = friendAccountNum;
	}
	public String getFriendNickName() {
		return friendNickName;
	}
	public void setFriendNickName(String friendNickName) {
		this.friendNickName = friendNickName;
	}
	public String getFriendHeadPath() {
		return friendHeadPath;
	}
	public void setFriendHeadPath(String friendHeadPath) {
		this.friendHeadPath = friendHeadPath;
	}
	
}

