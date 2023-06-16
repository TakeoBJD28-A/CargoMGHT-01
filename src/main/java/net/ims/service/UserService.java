package net.ims.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ims.entity.Category;
import net.ims.entity.Users;
import net.ims.repo.UserRepo;

@Service
public class UserService {
@Autowired
private UserRepo uRepo;

public int saveuser(Users u) {
	Users saveEnt=uRepo.save(u);
	
	if(saveEnt!=null)
		return 1;
	else
	return 0;

}

public List<Users> getAllUsers()
{
	return uRepo.findAll();
	}
 
    public Users getUserInfo(String email,String password) 
    {

    return uRepo.findByEmailAndPassword(email,password);	
       }
	
    
    
    public Users saveOrUpdateBook(Users user) {
		
		 Optional<Users> userOptional = uRepo.findById(user.getUid());
		   Users b= userOptional.get();
	             if (b!=null) 
		    	  b=uRepo.save(b);
		    
	           return b;

	}

	public Users getUserById(int uid) {
		return uRepo.findById(uid).get();
	}


	public boolean deleteUser(Integer id) {
		
		 Optional<Users> userOptional = uRepo.findById(id);
		    Users book=userOptional.get();
		    boolean flag =false;
		    if (book!=null) {
		    	uRepo.deleteById(id);
		       flag=true;
		    } else {
		    	
		        
		    }return flag;
	}
}
