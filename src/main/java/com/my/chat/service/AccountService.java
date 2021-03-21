package com.my.chat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.chat.dao.AccountDao;
import com.my.chat.dao.UserRepository;
import com.my.chat.model.Response;
import com.my.chat.model.User;

@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;
	@Autowired
	UserRepository userRepository;

	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	public Optional<User> UserLogin(String id, String password){
		return userRepository.findByIdAndPassword(id, password);
	}

	
	public Response UserSignup(String id, String name, String password){
		return accountDao.UserSignup(id, name, password);
	}
	

}
