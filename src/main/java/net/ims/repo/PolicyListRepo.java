package net.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ims.entity.PolicyList;
@Repository
public interface PolicyListRepo extends JpaRepository<PolicyList, Integer> {

}
