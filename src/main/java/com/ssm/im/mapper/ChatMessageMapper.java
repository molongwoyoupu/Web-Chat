package com.ssm.im.mapper;

import java.util.List;

import com.ssm.im.pojo.ChatMessage;

public interface ChatMessageMapper {

	public Long addChatMessage(ChatMessage chatMessage);
	
	public Long insertChatMessageList(List<ChatMessage> chatMessageList);
	
	public List<ChatMessage> getAllChatMessages();
	
	public List<ChatMessage> selectByChatMessage(ChatMessage chatMessage);
}
