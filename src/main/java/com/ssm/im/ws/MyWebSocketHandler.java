package com.ssm.im.ws;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssm.common.utils.JsonUtils;
import com.ssm.im.pojo.ChatMessage;
import com.ssm.im.service.ChatMessageService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


@Component
public class MyWebSocketHandler implements WebSocketHandler{

    @Autowired
    private ChatMessageService chatMessageService;

    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 当MyWebSocketHandler类被加载时就会创建该Map，随类而生
     */
    public static final Map<String, WebSocketSession> userSocketSessionMap;

    static {
        userSocketSessionMap = new HashMap<>();
    }

    /**
     * 握手实现连接后
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        String uid =  webSocketSession.getAttributes().get("uid").toString();
        if (userSocketSessionMap.get(uid) == null) {
            userSocketSessionMap.put(uid, webSocketSession);
        }
    }

    /**
     * 发送信息前的处理
     */
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

        if(webSocketMessage.getPayloadLength()==0){
            return;
        }

        logger.info(webSocketMessage.getPayload().toString());
        //得到Socket通道中的数据并转化为Message对象
        ChatMessage msg= JsonUtils.jsonToPojo(webSocketMessage.getPayload().toString(),ChatMessage.class);

        msg.setCreateTime(new Date());
        //将信息保存至数据库
        chatMessageService.addChatMessage(msg);

        //发送Socket信息
        sendMessageToUser(msg.getToUserId(), new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    /**
     * 在此刷新页面就相当于断开WebSocket连接,原本在静态变量userSocketSessionMap中的
     * WebSocketSession会变成关闭状态(close)，但是刷新后的第二次连接服务器创建的
     * 新WebSocketSession(open状态)又不会加入到userSocketSessionMap中,所以这样就无法发送消息
     * 因此应当在关闭连接这个切面增加去除userSocketSessionMap中当前处于close状态的WebSocketSession，
     * 让新创建的WebSocketSession(open状态)可以加入到userSocketSessionMap中
     * @param webSocketSession
     * @param closeStatus
     * @throws Exception
     */
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

        System.out.println("WebSocket--Closed:"+webSocketSession.getAttributes().get("uid")+"close connection");
        Iterator<Map.Entry<String,WebSocketSession>> iterator = userSocketSessionMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,WebSocketSession> entry = iterator.next();
            if(entry.getValue().getAttributes().get("uid").equals(webSocketSession.getAttributes().get("uid"))){
                userSocketSessionMap.remove(webSocketSession.getAttributes().get("uid").toString());
                logger.info("WebSocket in staticMap:" + webSocketSession.getAttributes().get("uid") + " removed");
            }
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 发送信息的实现
     */
    public void sendMessageToUser(String uid, TextMessage message)
            throws IOException {
        WebSocketSession session = userSocketSessionMap.get(uid);
        logger.info("session:"+session);
        if (session != null && session.isOpen()) {
            logger.info("session opened");
            session.sendMessage(message);
        }else{
            logger.info("session == null || closed");
        }
    }
}
