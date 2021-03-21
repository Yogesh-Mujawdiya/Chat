package com.my.chat.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.my.chat.model.Channel;
import com.my.chat.model.ChannelResponse;
import com.my.chat.model.Message;
import com.my.chat.model.MessageResponse;
import com.my.chat.model.Response;

@Repository
public class ChatDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	private static String GetChannel = "Select * from channel where (User1=:user1 and User2=:user2) or (User1=:user2 and User2=:user1)";
//	private static String GetChannel = "Select * from channel where (User1='12' and User2='1234') or (User1='1234' and User2='12')";
	
	private static String GetMessage = "Select * from message where Channel=:channelId";

	@SuppressWarnings("unchecked")
	public ChannelResponse getChannelId(String user1, String user2) {
		EntityManager session = entityManagerFactory.createEntityManager();
		List<Object[]> dbChannelList = session.createNativeQuery(GetChannel).setParameter("user1", user1).setParameter("user2", user2).getResultList();
//		List<Channel> channelList = session.createQuery(GetChannel, Channel.class).getResultList();
		ChannelResponse channelResponse;
		if(dbChannelList.size()!=0) {
			channelResponse = new ChannelResponse();
			Response response = new Response();		
			response.setStatus(true);
			response.setMessage("Channel Id  Created Successfuly");
			channelResponse.setId(Integer.parseInt(( dbChannelList.get(0)[0]+"")));
			channelResponse.setResponse(response);
		}
		else {
			channelResponse = getNewChannelId(user1,user2);
		}
		return channelResponse;
	}
	
	public ChannelResponse getNewChannelId(String user1, String user2) {
		EntityManager session = entityManagerFactory.createEntityManager();
		ChannelResponse channelResponse = new ChannelResponse();
		Response response = new Response();
		try {
			EntityTransaction entr = session.getTransaction();
			entr.begin();
			Channel channel = new Channel();
			channel.setUser1(user1);
			channel.setUser2(user2);
			session.persist(channel);
			System.out.println("ID : - "+channel.getId());
			channelResponse.setId(channel.getId());
			entr.commit();
			response.setStatus(true);
			response.setMessage("Channel Id  Created Successfuly");
		} catch (Exception ex) {
			response.setStatus(false);
			response.setMessage(ex.toString());
		} finally {
			session.close();
		}
		channelResponse.setResponse(response);
		return channelResponse;
	}

	@SuppressWarnings("unchecked")
	public MessageResponse getMessage(String channelId) {
		EntityManager session = entityManagerFactory.createEntityManager();
		List<Message> messageList = session.createNativeQuery(GetMessage, Message.class).setParameter("channelId", channelId).getResultList();
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setMessage(messageList);
		Response response = new Response();
		response.setStatus(true);
		response.setMessage("Get All Message");
		messageResponse.setResponse(response);
		return messageResponse;
	}


	public Response sendMessage(String sender, String channelId, String text) {
		EntityManager session = entityManagerFactory.createEntityManager();
		Response response = new Response();
		try {
			EntityTransaction entr = session.getTransaction();
			entr.begin();
			Message message = new Message();
			message.setChannelId(channelId);
			message.setSendBy(sender);
			message.setText(text);
			session.persist(message);
			entr.commit();
			response.setStatus(true);
			response.setMessage("Message Send Successfuly");
		} catch (Exception ex) {
			response.setStatus(false);
			response.setMessage(ex.toString());
		} finally {
			session.close();
		}
		return response;
	}

}
