package net.ims.service;

import java.util.List;

import net.ims.entity.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import net.ims.repo.CargoRepo;



@Repository
public class CargoServiceDaoImpl implements CargoServiceDAO {
	@Autowired
	private CargoRepo sRepo;

	public void saveCargo(Cargo s) {
		sRepo.save(s);

	}

	public List<Cargo> getAllCargo()
	{
		return sRepo.findAll();
		}
	
	
	public Cargo getCargoById(int id) {
		return sRepo.findById(id).get();
	}
	
	
	public void deleteById(int id) {
		sRepo.deleteById(id);
	}
	}


