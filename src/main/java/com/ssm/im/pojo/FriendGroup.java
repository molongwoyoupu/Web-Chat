package com.ssm.im.pojo;

import java.io.Serializable;
import java.util.Date;

public class FriendGroup implements Serializable{

	private static final long serialVersionUID = 2103621972339986274L;
	private Long id;
	private String userId;
	private String groupName;
	private String groupSort;
	private Date createTime;
	private Date updateTime;
	private Boolean availability=true;
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupSort() {
		return groupSort;
	}
	public void setGroupSort(String groupSort) {
		this.groupSort = groupSort;
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
	
}
