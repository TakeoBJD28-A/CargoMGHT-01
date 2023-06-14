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

import net.ims.entity.My_Policy_List;
import net.ims.service.My_Policy_ListService;


@Controller
public class My_Policy_ListController {
	@Autowired
	private My_Policy_ListService mservice;
	@GetMapping("/addmpl")
	public String getMy_Policy_List()
	{
		
		return"My_policy_List.html";
	}
	
	@PostMapping("/saveMy_Policy_List")
    public  String saveCat(@ModelAttribute My_Policy_List p)
		 
    {
		mservice.saveMy_Policy_List(p);	 
	 
		return"redirect:/getMy_Policy_List";
	   }
	@GetMapping("/getMy_Policy_List")
	public ModelAndView getAllMy_Policy_List()
	{
		List<My_Policy_List>clist=mservice.getAllMy_Policy_List();
		return new ModelAndView("My_Policy_ListDisplay.html","my",clist);
	}
	@RequestMapping("/editMy_Policy_List/{id}")
	public String editMy_Policy_List(@PathVariable int id,Model model) {
	My_Policy_List ed=mservice.getMy_Policy_ListById(id);
		model.addAttribute("my",ed);
		return "updateMy_Policy_List.html";
	}
	@RequestMapping("/deleteMy_Policy_List/{id}")
	public String deletePolicyList(@PathVariable int id) {
		mservice.deleteById(id);
		return "redirect:/getMy_Policy_List";
	}
	@GetMapping("/getMy_Policy_ListUser")
	public ModelAndView getAllMy_Policy_ListUser()
	{
		List<My_Policy_List>clist=mservice.getAllMy_Policy_List();
		return new ModelAndView("My_Policy_ListDisplayUser.html","my",clist);
	}
	@GetMapping("/getMy_Policy_ListMember")
	public ModelAndView getAllMy_Policy_ListM()
	{
		List<My_Policy_List>clist=mservice.getAllMy_Policy_List();
		return new ModelAndView("My_Policy_ListDisplayMember.html","my",clist);
	}
}
