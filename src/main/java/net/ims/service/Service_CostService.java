package net.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.ims.entity.Service_Cost;
import net.ims.repo.ServiceCostRepo;



@Repository
public class Service_CostService {
	@Autowired
	private ServiceCostRepo sRepo;

	public void saveService_Cost(Service_Cost s) {
		sRepo.save(s);

	}

	public List<Service_Cost> getAllService_Cost()
	{
		return sRepo.findAll();
		}
	
	
	public Service_Cost getService_CostById(int id) {
		return sRepo.findById(id).get();
	}
	
	
	public void deleteById(int id) {
		sRepo.deleteById(id);
	}
	}


