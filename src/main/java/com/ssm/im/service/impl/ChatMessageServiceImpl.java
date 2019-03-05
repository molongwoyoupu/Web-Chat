package com.ssm.im.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.common.pojo.DataResult;
import com.ssm.common.utils.JsonUtils;
import com.ssm.common.utils.RandomUtils;
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

	@Override
	public String getChatMsgList(int page, int rows,ChatMessage chatMessage) {
		// 查询之前,配置分页
		PageHelper.startPage(page, rows);
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
}
