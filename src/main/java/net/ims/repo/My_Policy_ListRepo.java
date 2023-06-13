package net.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ims.entity.My_Policy_List;
@Repository
public interface My_Policy_ListRepo extends JpaRepository<My_Policy_List, Integer> {

}
