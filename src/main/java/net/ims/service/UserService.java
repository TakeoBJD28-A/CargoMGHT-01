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

public void saveuser(Users u) {
	uRepo.save(u);

}

public List<Users> getAllUsers()
{
	return uRepo.findAll();
	}
 
    public Users getUserInfo(String email,String password) {

    return uRepo.findByEmailAndPassword(email,password);	
}
}
