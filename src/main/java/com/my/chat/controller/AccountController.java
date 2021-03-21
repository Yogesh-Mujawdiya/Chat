package com.my.chat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.my.chat.model.Response;
import com.my.chat.model.User;
import com.my.chat.service.AccountService;

@Api("Account")
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@CrossOrigin
	@GetMapping(value = "getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUser() throws Exception{
		return new ResponseEntity<List<User>> (accountService.getAllUser(), HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<User>> Login(
			@RequestParam(required = true, value="id") @ApiParam(value = "User Id", defaultValue="")String userId,
			@RequestParam(required = true, value="password") @ApiParam(value = "Password", defaultValue="")String password) throws Exception{
		return new ResponseEntity<Optional<User>> (accountService.UserLogin(userId, password), HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> Signup(
			@RequestParam(required = true, value="id") @ApiParam(value = "User Id", defaultValue="")String userId,
			@RequestParam(required = true, value="name") @ApiParam(value = "User Name", defaultValue="")String userName,
			@RequestParam(required = true, value="password") @ApiParam(value = "Password", defaultValue="")String password) throws Exception{
		return new ResponseEntity<Response> (accountService.UserSignup(userId, userName, password), HttpStatus.OK);
	}
}
