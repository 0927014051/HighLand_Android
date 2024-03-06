package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.PriceUpdateDetail;

@Repository
public interface PriceUpdateRepo extends JpaRepository<PriceUpdateDetail, Long>{
	
	

}
