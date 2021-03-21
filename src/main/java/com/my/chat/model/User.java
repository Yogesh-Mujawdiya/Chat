package com.my.chat.model;

import javax.persistence.*;

@Entity  
@Table(name="user", schema="my-chat")  
public class User {
	
	@Id
	@Column(name="Id")
	String id;
	
	@Column(name="Name")
	String name;
	
	@Column(name="Password")
	String password;

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
	
	
}
