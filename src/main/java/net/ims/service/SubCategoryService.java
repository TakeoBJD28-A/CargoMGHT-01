package net.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ims.entity.SubCategory;

import net.ims.repo.SubCategoryRepo;
@Repository
public class SubCategoryService {
	@Autowired
	private SubCategoryRepo sRepo;

	public void saveSubCategory(SubCategory s) {
		sRepo.save(s);

	}

	public List<SubCategory> getAllSubCategory()
	{
		return sRepo.findAll();
		}
	
	
	public SubCategory getSubCategoryById(int id) {
		return sRepo.findById(id).get();
	}
	
	
	public void deleteById(int id) {
		sRepo.deleteById(id);
	}
	}


