package com.ssm.im.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.ssm.common.utils.JsonUtils;
import com.ssm.common.utils.RandomUtils;
import com.ssm.im.mapper.ChatMessageMapper;
import com.ssm.im.pojo.ChatMessage;
import com.ssm.im.pojo.dto.ChatMessageCountDto;
import com.ssm.im.service.ChatMessageService;

import javax.annotation.Resource;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

	@Resource
	private ChatMessageMapper chatMessageMapper;

	@Override
	public Long addChatMessage(ChatMessage chatMessage) {
		return chatMessageMapper.addChatMessage(chatMessage);
	}

	@Override
	public String getChatMsgList(ChatMessage chatMessage) {
		// 查询之前,配置分页
		PageHelper.startPage(chatMessage.getPage(), chatMessage.getRows());
		// 进行查询
		List<ChatMessage> list = chatMessageMapper.selectByChatMessage(chatMessage);
		
		// 返回结果
		return JsonUtils.objectToJson(list);
	}

	@Override
	public void saveChatMsgList() {
		List<ChatMessage> msgList = new ArrayList<ChatMessage>();
		for (int i = 0; i < 500; i++) {
			ChatMessage msg = new ChatMessage();
			String me="" + (int) (Math.random() * 29 + 1);
			msg.setFromUserId(me);
			msg.setToUserId(getFriendId(me));
			msg.setMsgText(RandomUtils.getRandomChar((int) (Math.random() * 30+15)));
			msg.setCreateTime(new Date());
			msg.setUpdateTime(new Date());
			msgList.add(msg);
		}
		chatMessageMapper.insertChatMessageList(msgList);		
	}

	private String getFriendId(String me){
		String friend="" + (int) (Math.random() * 29 + 1);
		if(friend.equals(me)) {
			friend=getFriendId(me);
		}
		return friend;
	}

	@Override
	public String getNewestChatMsgList(ChatMessageCountDto dto) {
		// 查询之前,配置分页
		PageHelper.startPage(dto.getPage(), dto.getRows());
		// 进行查询
		List<ChatMessageCountDto> list = chatMessageMapper.selectNewestChatMsgDtoList(dto.getUserId());
		
		// 返回结果
		return JsonUtils.objectToJson(list);
	}
}
