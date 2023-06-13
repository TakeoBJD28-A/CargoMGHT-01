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


import net.ims.entity.SubCategory;
import net.ims.service.SubCategoryService;
@Controller
public class SubCategoryController {
	@Autowired
	private SubCategoryService sservice;
	@GetMapping("/addsb")
	public String getMySubcategory()
	{
		
		return"SubCategory.html";
	}
	
	@PostMapping("/saveSubCategory")
    public  String saveCat(@ModelAttribute SubCategory ss)
		 
    {
		sservice.saveSubCategory(ss);	 
	 
		return"redirect:/getSubCategory";
	   }
	@GetMapping("/getSubCategory")
	public ModelAndView getAllSubCategorylist()
	{
		List<SubCategory>clist=sservice.getAllSubCategory();
		return new ModelAndView("SubCategoryDisplay.html","scat",clist);
	}
	@RequestMapping("/editSubCategory/{sbid}")
	public String editCat(@PathVariable int sbid,Model model) {
	SubCategory c=sservice.getSubCategoryById(sbid);
		model.addAttribute("scat",c);
		return "updateSubCategory.html";
	}
	@RequestMapping("/deleteSubCategory/{sbid}")
	public String deleteCategory(@PathVariable int sbid) {
		sservice.deleteById(sbid);
		return "redirect:/getSubCategory";
	}
}
