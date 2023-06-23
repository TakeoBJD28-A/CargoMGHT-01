package net.ims.repo;

import net.ims.entity.TrackingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingInfoRepo extends JpaRepository <TrackingInfo,Integer> {
}
