package net.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ims.entity.SubCategory;

@Repository


public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer> {

}
