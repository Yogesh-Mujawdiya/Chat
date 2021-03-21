package com.my.chat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="message", schema="my-chat")  
public class Message {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;

	@Column(name="Channel")
	private String ChannelId;
	
	@Column(name="Sender")
	private String SendBy;
	
	@Column(name="Text")
	private String Text;

	@Column(name="Time", insertable = false, updatable = false)
	private String Time;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getChannelId() {
		return ChannelId;
	}
	public void setChannelId(String channelId) {
		ChannelId = channelId;
	}
	public String getSendBy() {
		return SendBy;
	}
	public void setSendBy(String sendBy) {
		SendBy = sendBy;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}

	
}
