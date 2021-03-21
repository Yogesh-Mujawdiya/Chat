package com.my.chat.model;

import java.util.List;

public class MessageResponse {

	List<Message> message;
	Response response;
	
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	
}
