package net.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ims.entity.My_Policy_List;
import net.ims.repo.My_Policy_ListRepo;



@Service
public class My_Policy_ListService {
	@Autowired
	private My_Policy_ListRepo mRepo;

	public void saveMy_Policy_List(My_Policy_List m) {
		mRepo.save(m);

	}

	public List<My_Policy_List> getAllMy_Policy_List()
	{
		return mRepo.findAll();
		}
	
	
	public My_Policy_List getMy_Policy_ListById(int id) {
		return mRepo.findById(id).get();
	}
	
	
	public void deleteById(int id) {
		mRepo.deleteById(id);
	}

}
