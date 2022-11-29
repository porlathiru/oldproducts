package com.oldproducts.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oldproducts.model.User;
import com.oldproducts.repository.MobileRepository;
import com.oldproducts.repository.UserRepository;

@Service
public class UserLogin {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MobileRepository mobileRepository;
	
	public List<Object> accountLogin(long mobile,String password)
	{
		User u=userRepository.getByMobile(mobile);
		
		List<Object>list=new ArrayList<>();
		
		if(u!=null)
		{
			if(password.equals(u.getPassword()))
			{
				long key=(long)(Math.random()*1000000000);
				u.setSkey(key);
				userRepository.save(u);
				list.add("Logged in succesfully");

				list.add(key);
				
				list.add(mobileRepository.findAll());

				return list;
			}
			else
			{
				list.add("Wrong password");
				return list;
			}	
		}
		else
		{
			list.add("Account does not exist. Create a new account...");
			return list;
		}
		
	}
}
