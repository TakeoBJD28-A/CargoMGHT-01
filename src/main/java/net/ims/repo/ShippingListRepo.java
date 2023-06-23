package net.ims.repo;

import net.ims.entity.ShippingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingListRepo extends JpaRepository <ShippingList,Integer>{
}
