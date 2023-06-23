package net.ims.controller;

import java.util.List;

import net.ims.entity.Cargo;

import net.ims.entity.Users;
import net.ims.service.CargoServiceDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class CorgoController {
   @Autowired
	private CargoServiceDaoImpl sservice;
	@GetMapping("/addCargo")
	public String InsertCargo()
	{

		return"AddCargo";
	}
	
	@PostMapping("/saveCargo")
    public  String saveSC(@ModelAttribute Cargo ss)
		 
    {
		sservice.saveCargo(ss);
	 
		return"redirect:/getCargo";
	   }
	@GetMapping("/getCargo")
	public String getAllService(Model model)
	{
		List<Cargo>clist=sservice.getAllCargo();
		model.addAttribute("scat", clist);
		return("CargoDisplayAdm.html");
	}
	@RequestMapping("/editCargo/{sbid}")
	public String editCat(@PathVariable int sbid,Model model) {
		Cargo c=sservice.getCargoById(sbid);
		model.addAttribute("scat",c);
		return "updateCargo.html";
	}
	@RequestMapping("/deleteCargo/{sbid}")
	public String deleteService_Cost(@PathVariable int sbid) {
		sservice.deleteById(sbid);
		return "redirect:/getCargo";
	}
	@GetMapping("/getCargoUser")
	public ModelAndView getAllService_Cost()
	{
		List<Cargo>clist=sservice.getAllCargo();
		return new ModelAndView("CargoDisplayUser.html","scat",clist);
	}
	@GetMapping("/getCargoMember")
	public ModelAndView getAllService_Costmeb()
	{
		List<Cargo>clist=sservice.getAllCargo();
		return new ModelAndView("CargoDisplayMember.html","scat",clist);
	}
}
