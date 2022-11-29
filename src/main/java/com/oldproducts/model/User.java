package com.oldproducts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private long mobile;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String password;

	
	private long skey;

	public long getSkey() {
		return skey;
	}

	public void setSkey(long skey) {
		this.skey = skey;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public User(int userid, String name, long mobile, String email, String address, String password) {
		super();
		this.userid = userid;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.password = password;
	}

	
	public User() {
		super();
	}
	
	

}
