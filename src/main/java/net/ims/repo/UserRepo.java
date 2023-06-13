package net.ims.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import net.ims.entity.Users;


@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	//findByxxx(-) Methods xxx stands on Entityclassname
	//Unmame /Address should be match
	Users findByEmailAndPassword(String email,String password);
	//Users findByUname(String uname,String address);
	
	//Users findByEmail(String email);
	
	//Customized Queries
	
	//@Query("from Users")
	//List<Users> findAll();
	
	//@Query("select uname from Users")
	//List<String> getNames();
	
	
	
	
}
