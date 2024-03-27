package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Size;

@Repository
public interface SizeRepo extends JpaRepository<Size, Long>{
	

}
