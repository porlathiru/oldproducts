package com.oldproducts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oldproducts.model.Mobiles;
import com.oldproducts.model.User;
import com.oldproducts.service.AddMobiles;
import com.oldproducts.service.DeleteUser;
import com.oldproducts.service.EditPassword;
import com.oldproducts.service.UserLogin;
import com.oldproducts.service.UserLogout;
import com.oldproducts.service.UserSignUp;

@RestController
public class ControlLayerClass {

	
	@RequestMapping("/test")
	public String testing()
	{
		String s="Application is working properly";
		return s;
	}
	
	
	@Autowired
	private UserSignUp userSignUp;
	
	@RequestMapping("/createAccount")
	public ResponseEntity<List<Object>> userCreateAccount(@RequestBody User u)
	{
		return userSignUp.createAccount(u);
	}
	
	
	@Autowired
	private UserLogin userLogin;
	
	@RequestMapping("/userLogin")
	public List<Object> login(@RequestHeader("mobile") long mobile,@RequestHeader("password") String password)
	{
		return userLogin.accountLogin(mobile,password);
	}
	
	@Autowired
	private AddMobiles addmob;
	
	@RequestMapping("/userLogin/addMob")
	public ResponseEntity<List<Object>> addMob(@RequestBody Mobiles mob,@RequestHeader long skey,@RequestHeader long mobile)
	{
		return addmob.addMobiles(mob,skey,mobile);
	}
	
	
	@Autowired
	private EditPassword editPassword;
	
	@RequestMapping("/userLogin/editPassword")
	public ResponseEntity<String> updatePassword(@RequestHeader long mobile, @RequestHeader String oldPassword, @RequestHeader long skey,@RequestHeader String newPassword)
	{
		return editPassword.changePassword(mobile, skey, oldPassword, newPassword);
	}
	
	
	@Autowired
	private DeleteUser deleteUser;
	@RequestMapping("/userLogin/deleteAccount")
	public String deleteUser(@RequestHeader long mobile,@RequestHeader long skey,@RequestHeader String password)
	{
		return deleteUser.removeUser(mobile, skey, password);
	}
	@Autowired
	private UserLogout userLogout;
	@RequestMapping("/logout")
	public String logoutAccount(@RequestHeader long mobile,@RequestHeader long skey) {
		return userLogout.userlogout(skey, mobile);
	}
}
