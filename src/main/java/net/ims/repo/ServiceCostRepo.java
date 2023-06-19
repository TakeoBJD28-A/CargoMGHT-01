package net.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ims.entity.Service_Cost;



@Repository


public interface ServiceCostRepo extends JpaRepository<Service_Cost, Integer> {

}
