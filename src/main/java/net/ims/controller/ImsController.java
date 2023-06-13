package net.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.ims.entity.Category;
import net.ims.entity.Users;
import net.ims.service.CategoryService;
import net.ims.service.UserService;

@Controller
public class ImsController {
	@Autowired
	private UserService service;
	@Autowired
	private CategoryService cservice;
	
	@RequestMapping("/")
	public String register()
	{
		
		return"home.html";
	}
	
	@GetMapping("/SignOut")
	public String registration()
	{
		
		return"register.html";
	}

	@GetMapping("/getusers")
	public ModelAndView allUsers()
	{
		List<Users>list=service.getAllUsers();
		return new ModelAndView("userdisplay.html","user",list);
	}
	
	@PostMapping("/save")
    public  String display(@ModelAttribute Users user)
		 
    {
		service.saveuser(user);	 
	 
		return"redirect:/getusers";
	   }
	
	@GetMapping("/SigIn")
	public String login()
	{
		
		return"Login.html";
	}

	@PostMapping("/login")
	public String login(@RequestParam("email") String email,@RequestParam("password")String passwor ,Model model) {
	 Users user =service.getUserInfo(email, passwor);
	 if (user != null) {
	            return "redirect:/DashBoard";
	        } else {
	            model.addAttribute("error", "Invalid username or password");
	            return "login";
	        }}
	        
	        @GetMapping("/DashBoard")
	    	public String dashbordpage()
	    	{
	    		
	    		return"DashBoard.html";
	    	}
	
	  }
