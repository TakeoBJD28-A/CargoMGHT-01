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

import net.ims.entity.PolicyList;
import net.ims.service.PolicyListService;


@Controller
public class PolicyListController {
	@Autowired
	private PolicyListService pservice;
	@GetMapping("/addpp")
	public String getMyPolicyList()
	{
		
		return"PolicyList.html";
	}
	
	@PostMapping("/savePolicyList")
    public  String saveCat(@ModelAttribute PolicyList p)
		 
    {
		pservice.savePolicyList(p);	 
	 
		return"redirect:/getPolicyList";
	   }
	@GetMapping("/getPolicyList")
	public ModelAndView getAllPolicylist()
	{
		List<PolicyList>clist=pservice.getAllPolicyList();
		return new ModelAndView("PolicyListDisplay.html","pol",clist);
	}
	@RequestMapping("/editPolicyList/{id}")
	public String editPol(@PathVariable int id,Model model) {
	PolicyList c=pservice.getPolicyListById(id);
		model.addAttribute("pol",c);
		return "updatePolicyList.html";
	}
	@RequestMapping("/deletePolicyList/{id}")
	public String deletePolicyList(@PathVariable int id) {
		pservice.deleteById(id);
		return "redirect:/getPolicyList";
	}
	@GetMapping("/getPolicyListUser")
	public ModelAndView getAllPolicylistUser()
	{
		List<PolicyList>clist=pservice.getAllPolicyList();
		return new ModelAndView("PolicyListDisplayUser.html","pol",clist);
	}
	@GetMapping("/getPolicyListMember")
	public ModelAndView getAllPolicylistM()
	{
		List<PolicyList>clist=pservice.getAllPolicyList();
		return new ModelAndView("PolicyListDisplayMember.html","pol",clist);
	}
}
