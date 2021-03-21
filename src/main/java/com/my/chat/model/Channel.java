package com.my.chat.model;

import javax.persistence.*;

@Entity  
@Table(name="channel", schema="my-chat")  
public class Channel {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	
	@Column(name="User1")
	String User1;
	
	@Column(name="User2")
	String User2;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUser1() {
		return User1;
	}

	public void setUser1(String user1) {
		User1 = user1;
	}

	public String getUser2() {
		return User2;
	}

	public void setUser2(String user2) {
		User2 = user2;
	}
	
	

}
