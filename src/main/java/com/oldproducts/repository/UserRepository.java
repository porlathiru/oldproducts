package com.oldproducts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.oldproducts.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User getByMobile(long mobile);
	
	public User getByEmail(String email);

}
