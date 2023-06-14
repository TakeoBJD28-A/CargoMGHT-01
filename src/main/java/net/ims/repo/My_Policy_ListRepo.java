package net.ims.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.ims.entity.My_Policy_List;
@Repository
public interface My_Policy_ListRepo extends JpaRepository<My_Policy_List, Integer> {

	
	//get column Value from two table//Core concept
	//@Query("select uname from Users")
	//List<String> getNames();
	
/*@Query("SELECT t1.uname, t1.email, t1.phone, t2.category, t2.cubCategory, t2.name, t2.sumAssured, t2.Premium " +
	            "FROM Users t1 JOIN PolicyList t2 ON t1.uid = :userId AND t2.id = :policyId")
	    
List<My_Policy_ListRepo> getUserPolicyDetails(@Param("userId") int userId, @Param("policyId") int policyId);
	*/}


