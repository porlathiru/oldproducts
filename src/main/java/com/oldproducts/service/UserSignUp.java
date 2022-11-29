package com.oldproducts.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oldproducts.model.User;
import com.oldproducts.repository.UserRepository;

@Service
public class UserSignUp {

	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<List<Object>> createAccount(User u)
	{
		List<Object>list=new ArrayList<>();
		
		User usermob=userRepository.getByMobile(u.getMobile());
		User useremail=userRepository.getByEmail(u.getEmail());
		
		if(usermob!=null)
		{
			list.add("Mobile number already exists");
			return ResponseEntity.status(400).body(list);
		}
		else 
		if(useremail!=null)
		{
			list.add("Email ID already exists");
			return ResponseEntity.status(400).body(list);
		}
		else
		{
			userRepository.save(u);
			list.add("Account created succesfully");
			list.add(u);
			return ResponseEntity.status(200).body(list);
		}
	}
}

