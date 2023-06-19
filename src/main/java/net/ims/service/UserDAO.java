package net.ims.service;

import java.util.List;

import net.ims.entity.Users;
import net.ims.exceptionalhandler.RecordNotFoundException;

public interface UserDAO  {
	
	
	public int saveuser(Users u);
		
	public List<Users> getAllUsers();
	
    public Users saveOrUpdateBook(Users user); 
			
	public Users getUserById(int uid);
	public boolean deleteUser(Integer id);
			
	public Users findByEmail(String email)throws RecordNotFoundException;
			
			
			
			
			
		
			
		
		
	


}
