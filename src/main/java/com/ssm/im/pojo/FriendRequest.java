package com.ssm.im.pojo;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 	好友请求
 *
 */
public class FriendRequest implements Serializable{

	private static final long serialVersionUID = -2303267133098810463L;
	private Long id;
	private String userId;
	private String reqToId;
	private String reqType;
	private String reqRemark;
	//请求分组
	private String reqGroupId;
	//默认为0，同意为1，拒绝为2
	private String reqResult;
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
	public String getReqToId() {
		return reqToId;
	}
	public void setReqToId(String reqToId) {
		this.reqToId = reqToId;
	}
	public String getReqType() {
		return reqType;
	}
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public String getReqRemark() {
		return reqRemark;
	}
	public void setReqRemark(String reqRemark) {
		this.reqRemark = reqRemark;
	}
	public String getReqGroupId() {
		return reqGroupId;
	}
	public void setReqGroupId(String reqGroupId) {
		this.reqGroupId = reqGroupId;
	}
	public String getReqResult() {
		return reqResult;
	}
	public void setReqResult(String reqResult) {
		this.reqResult = reqResult;
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
