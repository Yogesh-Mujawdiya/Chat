package com.my.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.my.chat.model.ChannelResponse;
import com.my.chat.model.MessageResponse;
import com.my.chat.model.Response;
import io.swagger.annotations.ApiParam;
import com.my.chat.service.ChatService;

@Controller
public class ChatController {

	
	@Autowired
	ChatService chatService;

	@CrossOrigin
	@PostMapping(value = "getChannelId", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChannelResponse> getChannelId(
			@RequestParam(required = true, value="user1") @ApiParam(value = "User1 Id", defaultValue="")String user1,
			@RequestParam(required = true, value="user2") @ApiParam(value = "User2 Id", defaultValue="")String user2
			){
		return new ResponseEntity<ChannelResponse> (chatService.GetChannelId(user1, user2), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "getMessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageResponse> getAllMessage(
			@RequestParam(required = true, value="channelId") @ApiParam(value = "Channel Id", defaultValue="")String channelId
			){
		return new ResponseEntity<MessageResponse> (chatService.GetAllMessage(channelId), HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping(value = "sendMessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> sendMessage(
			@RequestParam(required = true, value="channelId") @ApiParam(value = "Channel Id", defaultValue="")String channelId,
			@RequestParam(required = true, value="senderId") @ApiParam(value = "sender Id", defaultValue="")String sender,
			@RequestParam(required = true, value="text") @ApiParam(value = "Message", defaultValue="")String text
			){
		return new ResponseEntity<Response> (chatService.SendMessage(channelId, sender, text), HttpStatus.OK);
	}
	
}
