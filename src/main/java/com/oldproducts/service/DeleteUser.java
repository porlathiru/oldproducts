package com.oldproducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oldproducts.model.Mobiles;
import com.oldproducts.model.User;
import com.oldproducts.repository.MobileRepository;
import com.oldproducts.repository.UserRepository;

@Service
public class DeleteUser {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MobileRepository mobileRepository;
	
	public String removeUser(long mobile,long skey,String password)
	{
		User u=userRepository.getByMobile(mobile);
		Mobiles mob=mobileRepository.deleteByUserid(u.getUserid());
		if(skey==u.getSkey())
		{
			if(password.equals(u.getPassword()))
			{
				mobileRepository.delete(mob);
//				mobileRepository.deleteById(u.getUserid());
//				mobileRepository.deleteAll(u.getUserid());
				userRepository.deleteById(u.getUserid());
				
				return "Account deleted succesfully";
			}
			else return "Wrong Password";
		}
		return "Session Expired";
	}
}
