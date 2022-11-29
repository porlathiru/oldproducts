package com.oldproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oldproducts.model.Mobiles;

@Repository
public interface MobileRepository extends JpaRepository<Mobiles, Integer>{
	public Mobiles deleteByUserid(int userid);

}
