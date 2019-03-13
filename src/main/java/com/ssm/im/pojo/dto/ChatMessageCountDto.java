package com.ssm.im.pojo.dto;

import java.io.Serializable;
import java.util.Date;

import com.ssm.common.pojo.BasePage;

public class ChatMessageCountDto extends BasePage implements Serializable{

	private static final long serialVersionUID = 8296131461676544834L;
	private String chatUserId;
	private String chatUserNickName;
	private String chatUserAccountNum;
	private String chatUserHeadPath;
	private String lastMsgText;//最近一条消息
	private String lastSendUserId;//最近消息发送者
	private Date createTime;
	private Long noReadCount;//未读消息数
	private String userId;//自身id
	public String getChatUserId() {
		return chatUserId;
	}
	public void setChatUserId(String chatUserId) {
		this.chatUserId = chatUserId;
	}
	public String getChatUserNickName() {
		return chatUserNickName;
	}
	public void setChatUserNickName(String chatUserNickName) {
		this.chatUserNickName = chatUserNickName;
	}
	public String getChatUserAccountNum() {
		return chatUserAccountNum;
	}
	public void setChatUserAccountNum(String chatUserAccountNum) {
		this.chatUserAccountNum = chatUserAccountNum;
	}
	public String getChatUserHeadPath() {
		return chatUserHeadPath;
	}
	public void setChatUserHeadPath(String chatUserHeadPath) {
		this.chatUserHeadPath = chatUserHeadPath;
	}
	public String getLastMsgText() {
		return lastMsgText;
	}
	public void setLastMsgText(String lastMsgText) {
		this.lastMsgText = lastMsgText;
	}
	public String getLastSendUserId() {
		return lastSendUserId;
	}
	public void setLastSendUserId(String lastSendUserId) {
		this.lastSendUserId = lastSendUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getNoReadCount() {
		return noReadCount;
	}
	public void setNoReadCount(Long noReadCount) {
		this.noReadCount = noReadCount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
