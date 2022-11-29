package com.oldproducts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oldproducts.model.Mobiles;
import com.oldproducts.model.User;
import com.oldproducts.repository.MobileRepository;
import com.oldproducts.repository.UserRepository;

@Service
public class AddMobiles {
	
	@Autowired
	private MobileRepository mobileRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<List<Object>> addMobiles(Mobiles mob,long skey,long mobile)
	{
		List<Object>list=new ArrayList<>();
		
		User u=userRepository.getByMobile(mobile);
		
		if(u!=null)
		{
			if(skey==u.getSkey())
			{
				mob.setUserid(u.getUserid());
				mobileRepository.save(mob);
				list.add("Following product added succesfully: ");
				list.add(mob);
				return ResponseEntity.status(200).body(list);
			}
			else
			{
				list.add("Session expired");
				return ResponseEntity.status(440).body(list);
			}
				
		}
		else
		{
			list.add("User does not exist...");
			return ResponseEntity.status(404).body(list);
		}
		
		
	}
}
