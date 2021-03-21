package com.my.chat.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.chat.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	List<User> findAll();

	Optional<User> findById(String UserId);
	
	Optional<User> findByIdAndPassword(String UserId, String Password);

}
