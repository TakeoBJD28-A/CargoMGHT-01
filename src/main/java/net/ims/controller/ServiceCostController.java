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

import net.ims.entity.Service_Cost;

import net.ims.service.Service_CostService;

@Controller
public class ServiceCostController {
   @Autowired
	private Service_CostService sservice;
	@GetMapping("/addsb")
	public String getMySubcategory()
	{
		
		return"ServiceCost.html";
	}
	
	@PostMapping("/saveServiceCost")
    public  String saveSC(@ModelAttribute Service_Cost ss)
		 
    {
		sservice.saveService_Cost(ss);	 
	 
		return"redirect:/getServiceCost";
	   }
	@GetMapping("/getServiceCost")
	public String getAllService_Costlist(Model model)
	{
		List<Service_Cost>clist=sservice.getAllService_Cost();
		model.addAttribute("scat", clist);
		return("ServiceCostDisplayAdm.html");
	}
	@RequestMapping("/editServiceCost/{sbid}")
	public String editCat(@PathVariable int sbid,Model model) {
		Service_Cost c=sservice.getService_CostById(sbid);
		model.addAttribute("scat",c);
		return "updateServiceCost.html";
	}
	@RequestMapping("/deleteServiceCost/{sbid}")
	public String deleteService_Cost(@PathVariable int sbid) {
		sservice.deleteById(sbid);
		return "redirect:/getServiceCost";
	}
	@GetMapping("/getServiceCostUser")
	public ModelAndView getAllService_Cost()
	{
		List<Service_Cost>clist=sservice.getAllService_Cost();
		return new ModelAndView("ServiceCostDisplayUser.html","scat",clist);
	}
	@GetMapping("/getServiceCostMember")
	public ModelAndView getAllService_Costmeb()
	{
		List<Service_Cost>clist=sservice.getAllService_Cost();
		return new ModelAndView("ServiceCostDisplayMember.html","scat",clist);
	}
}
