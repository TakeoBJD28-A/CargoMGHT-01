package net.ims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.ims.entity.Feedback;
import net.ims.service.FeedbackService;


@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackService fService;
	
	
	@RequestMapping("/add_feedback")
	public String showAddForm(Feedback feedback, Model model)
	{
		model.addAttribute("feedback", feedback);
		return "contact.html";
		
	}
	
	@RequestMapping("/feedbacks")
	public String getAllFeedbacks(Feedback feedback, Model model) {
		
    List<Feedback> allFeedbacks = fService.getAllFeedbacks();
	  model.addAttribute("allFeedbacks", allFeedbacks);
	  return "Feedback.html";
    
    
	
	}
	
	@PostMapping("/insert")
	public String handleForm(@ModelAttribute Feedback feedback, Model model)
	{
		Feedback addFeedback = fService.addFeedback(feedback);	
		return "redirect:/home";
	}
	
	@RequestMapping("/home")
	public String home(Feedback feedback, Model model)
	{
		/*
		 * List<Feedback> allFeedbacks = fService.getAllFeedbacks();
		 * 
		 * model.addAttribute("allFeedbacks", allFeedbacks);
		 */
		
		return "Index.html";
		
		
	}
	
	
	
	@RequestMapping(path = {"/delete/{id}"})
	public String delete(Model model,@PathVariable Integer id)
	{
	    fService.deleteFeedback(id);
		
		return"redirect:/";
		
	}
	
	
}



