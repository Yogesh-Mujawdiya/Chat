package com.my.chat.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.chat.model.Response;
import com.my.chat.model.User;

@Repository
public class AccountDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

//	private static String InsertUser = "INSERT INTO my-chat.user(Id, Name, Password) VALUES (:user_id, :name, :password)";

	public Response UserSignup(String userId, String name, String password) {
		EntityManager session = entityManagerFactory.createEntityManager();
		Response response = new Response();
		try {
			EntityTransaction entr = session.getTransaction();
			entr.begin();
			User user = new User();
			user.setId(userId);
			user.setName(name);
			user.setPassword(password);
			session.persist(user);
			entr.commit();
			response.setStatus(true);
			response.setMessage("User Registration Successful");
		} catch (Exception ex) {
			response.setStatus(false);
			response.setMessage(ex.toString());
		} finally {
			session.close();
		}
		return response;
	}

}
