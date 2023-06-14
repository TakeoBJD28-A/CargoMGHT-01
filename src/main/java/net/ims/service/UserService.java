package net.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
