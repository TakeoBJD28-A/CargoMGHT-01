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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import net.ims.entity.Users;
import net.ims.exceptionalhandler.RecordNotFoundException;
import net.ims.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	
	@RequestMapping("/aboutus")
	public String companyprofile()
	{
		
		return"AboutUs";
	}
	@RequestMapping("/teams")
	public String companyteams()
	{
		
		return"teams";
	}
	@RequestMapping("/why")
	public String why()
	{
		
		return"why.html";
	}
	@RequestMapping("/contact")
	public String contact()
	{
		
		return"contact.html";
	}
	@RequestMapping("/service")
	public String service()
	{
		
		return"Service.html";
	}

	@RequestMapping("/")
	public String register()
	{
		
		return"Index.html";
	}
	
	@RequestMapping("/homeUser")
	public String homeuser()
	{
		
		return"homeUsers.html";
	}
	
	@GetMapping("/SignOut")
	public String registration()
	{
		
		return"register.html";
	}
	 @PostMapping("/saveuserbyAdmin")
	  public  String update(@ModelAttribute Users user,Model model)
		 
	    {   
			int count=service.saveuser(user);
			String msg=" ";
			      if(count!=0)
				       msg="Update Success";
				    else 
				      msg="Try Later!";
			
			   model.addAttribute("msg",msg);
			return"redirect:/getusers";
					}
	  
	 @PostMapping("/save")
	  public  String display(@ModelAttribute Users user,Model model)
		 
	    {   
			int count=service.saveuser(user);
			String msg=" ";
			      if(count!=0)
				       msg="Registration Success";
				    else 
				      msg="Try Later!";
			
			model.addAttribute("msg",msg);
			return"home";
					}
	
	

	@GetMapping("/getusers")
	public ModelAndView allUsers()
	{
		List<Users>list=service.getAllUsers();
		return new ModelAndView("userdisplay.html","user",list);
	}
	
	
	
	@GetMapping("/SignIn")
	public String login()
	{
		
		return"Loginnew";
	}
	
	@GetMapping("/LogOut")
	public String logout()
	{
		
		return"home.html";
	}

	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,@RequestParam("password")String passwor ,Model model) {
	 Users user =service.getUserInfo(email, passwor);
	
	 if(user!=null) {
	             if (user.getRole_id() == 1) 
		      
	             return "redirect:/Admin";
	             
	              else return"redirect:/DashBoard";
	        
	              } else {
	               model.addAttribute("error", "Invalid username or password");
	               return "loginnew";
	        }}
    
	   @GetMapping("/Admin")
	   public String adminPage()
	   {
	    		
	    		return"homeAdmin.html";
	    	}
	   
	   @GetMapping("/DashBoard")
	   public String dashbordPage()
	   {
	    		
	    		return"DashBoard.html";
	    	}
	   @RequestMapping("/editUser/{uid}")
		public String edituser(@PathVariable int uid,Model model) {
		Users c=service.getUserById(uid);
			model.addAttribute("pol",c);
			return "updateUser.html";
		}
		@RequestMapping("/deleteUser/{uid}")
		public String deleteUser(@PathVariable int uid) {
			service.deleteUser(uid);
			return "redirect:/getusers";
		}
		@RequestMapping("/findpsw")
		public String findBook()
		{
			
			return"passwordSearch";
		}
		
		@GetMapping("/findpassword")
		public String displayBookById(@RequestParam("email") String email, Model model) {
		    try {
		        Users b = service.findByEmail(email);
		        model.addAttribute("psw", b);
		        
		    } catch (RecordNotFoundException e) {
		        model.addAttribute("error", "Book not found");
		    }
		    return "Displaypassword";
		}
		}
	
	  
