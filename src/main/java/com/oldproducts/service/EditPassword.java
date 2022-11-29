package com.oldproducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oldproducts.model.User;
import com.oldproducts.repository.UserRepository;

@Service
public class EditPassword {

	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<String> changePassword(long mobile,long skey,String oldpassword,String newPassword)
	{
		User u= userRepository.getByMobile(mobile);
		
		if(u.getSkey()==skey)
		{
			if(oldpassword.equals(u.getPassword()))
			{
				u.setPassword(newPassword);
				userRepository.save(u);
				return ResponseEntity.status(200).body("Password changed successfully");
			}
			else
			{
				return ResponseEntity.status(401).body("Wrong password");
			}
		}
		else
		{
			return ResponseEntity.status(440).body("Session expired");
		}
	}
}
