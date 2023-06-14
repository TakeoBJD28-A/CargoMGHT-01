package net.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import net.ims.entity.Category;
import net.ims.repo.CategoryRepo;


@Service
public class CategoryService {


	@Autowired
	private CategoryRepo cRepo;

	public void saveCategory(Category c) {
		cRepo.save(c);

	}

	public List<Category> getAllCategory()
	{
		return cRepo.findAll();
		}
	
	
	public Category getCategoryById(int id) {
		return cRepo.findById(id).get();
	}
	
	
	public void deleteById(int id) {
		cRepo.deleteById(id);
	}
	}

