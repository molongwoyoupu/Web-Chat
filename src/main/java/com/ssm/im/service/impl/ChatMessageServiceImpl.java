package com.ssm.im.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.im.mapper.ChatMessageMapper;
import com.ssm.im.pojo.ChatMessage;
import com.ssm.im.service.ChatMessageService;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

	@Autowired
	private ChatMessageMapper chatMessageMapper;
	@Override
	public Long addChatMessage(ChatMessage chatMessage) {
		return chatMessageMapper.addChatMessage(chatMessage);
	}

}
