package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Category_Size;

@Repository
public interface SizeCategoryRepo extends JpaRepository<Category_Size, Long>{
	

}
