package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WhatsappService {
	
	WhatsappRepository repository=new WhatsappRepository();

	public String createUser(String name, String mobile) throws Exception {
		// TODO Auto-generated method stub
		if(repository.usermap.containsValue(mobile))
		{
			throw new Exception("User already exists");
		}
		User user=new User();
		user.setName(name);
		user.setMobile(mobile);
		
		repository.usermap.put(user, mobile);
		
		return "SUCCESS";
	}

	public Group createGroup(List<User> users) {
		// TODO Auto-generated method stub
		Group group=new Group();
		String s="Group ";
		int size=users.size();
		if(size<=2)
		{
			group.setAdmin(users.get(0));
			group.setNumberOfParticipants(size);
			group.setName(users.get(size-1).getName());
		}
		else
		{
			group.setAdmin(users.get(0));
			group.setNumberOfParticipants(size);
			group.setName(s+repository.groupMap.size()+1);
		}
		repository.groupMap.put(group, users);
		return group;
	}

	public int createMessage(String content) {
		// TODO Auto-generated method stub
		
		Message message=new Message();
		message.setContent(content);
		message.setId(repository.messageMap.size()+1);
		List<Message> messages=new ArrayList<>();
		messages.add(message);
		repository.messageMap.put(null, messages);
		
		return repository.messageMap.size()+1;
	}

	public int sendMessage(Message message, User sender, Group group) throws Exception {
		// TODO Auto-generated method stub
		if(!repository.groupMap.containsKey(group))
		{
			throw new Exception("Group does not exist");
		}
		List<User> users=repository.groupMap.get(group);
		if(!users.contains(sender))
		{
			throw new Exception("You are not allowed to send message");
		}
		List<Message> messages=repository.messageMap.get(group);
		messages.add(message);
		repository.messageMap.put(group, messages);
		
		return repository.messageMap.size()+1;
	}

	public String changeAdmin(User approver, User user, Group group) throws Exception {
		// TODO Auto-generated method stub
		if(!repository.groupMap.containsKey(group))
		{
			throw new Exception("Group does not exist");
		}
		List<User> users=repository.groupMap.get(group);
		if(!users.contains(approver))
		{
			throw new Exception("Approver does not have rights");
		}
		if(!users.contains(user))
		{
			throw new Exception("User is not a participant");
		}
		Group group2=group;
		group2.setAdmin(user);
		repository.groupMap.remove(group);
		repository.groupMap.put(group2, users);
		
		return "SUCCESS";
	}

	public int removeUser(User user) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	public String findMessage(Date start, Date end, int k) {
		// TODO Auto-generated method stub
		return null;
	}

}
