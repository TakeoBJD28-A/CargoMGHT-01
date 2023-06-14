package net.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import net.ims.entity.Category;
import net.ims.service.CategoryService;
@Controller
public class CategoryController {
	@Autowired
	private CategoryService cservice;
	@GetMapping("/add")
	public String getMycategory()
	{
		
		return"Category.html";
	}
	
	@PostMapping("/saveCategory")
    public  String saveCat(@ModelAttribute Category cs)
		 
    {
		cservice.saveCategory(cs);	 
	 
		return"redirect:/getCategory";
	   }
	@GetMapping("/getCategory")
	public ModelAndView getAllCategorylist()
	{
		List<Category>clist=cservice.getAllCategory();
		return new ModelAndView("CategoryDisplay.html","cat",clist);
	}
	@RequestMapping("/editCategory/{cid}")
	public String editCat(@PathVariable int cid,Model model) {
	Category c=cservice.getCategoryById(cid);
		model.addAttribute("cat",c);
		return "updateCategory.html";
	}
	@RequestMapping("/deleteCategory/{cid}")
	public String deleteCategory(@PathVariable int cid) {
		cservice.deleteById(cid);
		return "redirect:/getCategory";
	}
	@GetMapping("/getCategoryUser")
	public ModelAndView getAllCategorylistUser()
	{
		List<Category>clist=cservice.getAllCategory();
		return new ModelAndView("CategoryDisplayUser.html","cat",clist);
	}
	@GetMapping("/getCategoryMember")
	public ModelAndView getAllCategorylistm()
	{
		List<Category>clist=cservice.getAllCategory();
		return new ModelAndView("CategoryDisplayMember.html","cat",clist);
	}
}
