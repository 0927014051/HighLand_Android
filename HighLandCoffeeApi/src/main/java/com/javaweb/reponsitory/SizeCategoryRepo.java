package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Category_Size;

@Repository
public interface SizeCategoryRepo extends JpaRepository<Category_Size, Long>{

    @Query(value = "SELECT * FROM Category_Size  WHERE size_id = ?1 AND category_id = ?2",nativeQuery = true)
    Category_Size findCategory_SizeBySizeId(Long size_id, Long category_id); 
}
