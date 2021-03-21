package com.my.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.chat.dao.ChatDao;
import com.my.chat.model.ChannelResponse;
import com.my.chat.model.MessageResponse;
import com.my.chat.model.Response;

@Service
public class ChatService {

	@Autowired
	ChatDao chatDao;
	
	public ChannelResponse GetChannelId(String user1, String user2){
		return chatDao.getChannelId(user1, user2);
	}

	
	public MessageResponse GetAllMessage(String channelId){
		return chatDao.getMessage(channelId);
	}
	

	public Response SendMessage(String channelId, String sender, String text){
		return chatDao.sendMessage(sender, channelId, text);
	}
	
}
