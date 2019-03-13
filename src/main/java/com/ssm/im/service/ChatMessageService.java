package com.ssm.im.service;

import com.ssm.im.pojo.ChatMessage;
import com.ssm.im.pojo.dto.ChatMessageCountDto;

public interface ChatMessageService {

	public Long addChatMessage(ChatMessage chatMessage);
	
	public void saveChatMsgList();
	
	public String getChatMsgList(ChatMessage chatMessage);
	
	
	public String getNewestChatMsgList(ChatMessageCountDto dto);
}
