package net.ims.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ims.entity.Category;



@Repository


public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
