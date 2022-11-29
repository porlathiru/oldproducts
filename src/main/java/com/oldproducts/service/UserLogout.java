package com.oldproducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oldproducts.model.User;
import com.oldproducts.repository.UserRepository;

@Service
public class UserLogout {
	@Autowired
	private UserRepository userRepository;
	public String userlogout(long skey,long mobile) {
		
		User u=userRepository.getByMobile(mobile);
		if(u!=null) {
			if(skey==u.getSkey()) {
				u.setSkey(0);
				userRepository.save(u);
				return "Loggedout successfully";
			}
			else return "Session Expired";
		}
		return "error in Loggingout";
	}

}
