package com.ssm.im.service;

import com.ssm.im.pojo.ChatMessage;

public interface ChatMessageService {

	public Long addChatMessage(ChatMessage chatMessage);
	
	public void saveChatMsgList();
	
	public String getChatMsgList(int page, int rows,ChatMessage chatMessage);
}
