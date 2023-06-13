package net.ims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ims.entity.PolicyList;

import net.ims.repo.PolicyListRepo;

@Service
public class PolicyListService {
	@Autowired
	private PolicyListRepo pRepo;

	public void savePolicyList(PolicyList s) {
		pRepo.save(s);

	}

	public List<PolicyList> getAllPolicyList()
	{
		return pRepo.findAll();
		}
	
	
	public PolicyList getPolicyListById(int id) {
		return pRepo.findById(id).get();
	}
	
	
	public void deleteById(int id) {
		pRepo.deleteById(id);
	}
	}

