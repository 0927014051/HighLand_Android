package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Size;

@Repository
public interface SizeRepo extends JpaRepository<Size, Long>{
    @Query("SELECT * FROM Size  WHERE size_name = :size_name")
    public Size findSizeByName(String size_name);

}
