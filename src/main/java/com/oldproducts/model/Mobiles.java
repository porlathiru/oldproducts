package com.oldproducts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mobiles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mobileid;
	
	public int getMobileid() {
		return mobileid;
	}

	@Column(nullable=false)
	private String mob_brand;
	
	@Column(nullable=false)
	private double mob_price;
	
	@Column(nullable=false)
	private String mob_color;
	
	@Column(nullable=false)
	private int mob_camera;
	
	@Column(nullable=false)
	private int mob_ram;
	
	@Column(nullable=false)
	private int mob_storage;

	@Column(nullable=false)
	private int userid;
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getMob_brand() {
		return mob_brand;
	}

	public void setMob_brand(String mob_brand) {
		this.mob_brand = mob_brand;
	}

	public double getMob_price() {
		return mob_price;
	}

	public void setMob_price(double mob_price) {
		this.mob_price = mob_price;
	}

	public String getMob_color() {
		return mob_color;
	}

	public void setMob_color(String mob_color) {
		this.mob_color = mob_color;
	}

	public int getMob_camera() {
		return mob_camera;
	}

	public void setMob_camera(int mob_camera) {
		this.mob_camera = mob_camera;
	}

	public int getMob_ram() {
		return mob_ram;
	}

	public void setMob_ram(int mob_ram) {
		this.mob_ram = mob_ram;
	}

	public int getMob_storage() {
		return mob_storage;
	}

	public void setMob_storage(int mob_storage) {
		this.mob_storage = mob_storage;
	}

	public Mobiles(int mobileid, String mob_brand, double mob_price, String mob_color, int mob_camera, int mob_ram,
			int mob_storage) {
		super();
		this.mobileid = mobileid;
		this.mob_brand = mob_brand;
		this.mob_price = mob_price;
		this.mob_color = mob_color;
		this.mob_camera = mob_camera;
		this.mob_ram = mob_ram;
		this.mob_storage = mob_storage;
	}

	
	public Mobiles() {
		super();
	}
	
	
}
