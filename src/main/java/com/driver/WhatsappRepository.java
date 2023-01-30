package com.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class WhatsappRepository {
	
	Map<User,String> usermap=new HashMap<>();
	Map<Group,List<User>> groupMap=new HashMap<>();
	Map<Group,List<Message>> messageMap=new HashMap<>();
	

}
