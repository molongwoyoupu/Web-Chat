package com.ssm.im.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.im.pojo.ChatMessage;
import com.ssm.im.service.ChatMessageService;

@Controller
public class ChatMessageController {
	@Autowired
	private ChatMessageService chatMessageService;

	
	/**
	 * 获取消息列表
	 * @param page 页数
	 * @param rows 行数
	 * @return
	 */
	@RequestMapping(value = "/getChatMsgList",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
    @ResponseBody
    public String getChatMsgList(int page,int rows,ChatMessage chatMessage){
		
        return chatMessageService.getChatMsgList(page,rows,chatMessage);
    }
	
	/**
	 * 随机创建消息
	 */
	@RequestMapping(value = "/saveChatMsgList")
	@ResponseBody
    public void saveChatMsgList(){
		chatMessageService.saveChatMsgList();
    }
}
