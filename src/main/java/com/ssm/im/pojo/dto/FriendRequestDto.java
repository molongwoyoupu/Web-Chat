package com.ssm.im.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.ssm.common.pojo.BasePage;

public class FriendRequestDto  extends BasePage implements Serializable{

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
	
	//交流对象的用户信息
	private String nickName;
	private String accountNum;
	private String headPath;
	private String gender;
	private String age;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getHeadPath() {
		return headPath;
	}
	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
