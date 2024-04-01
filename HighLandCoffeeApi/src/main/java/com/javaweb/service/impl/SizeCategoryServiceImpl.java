package com.javaweb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Category_Size;
import com.javaweb.reponsitory.SizeCategoryRepo;
import com.javaweb.request.AddCategorySizeRequest;
import com.javaweb.service.SizeCategoryService;

@Service
public class SizeCategoryServiceImpl implements SizeCategoryService{
	
	private SizeCategoryRepo sizeCategoryRepo;

	public SizeCategoryServiceImpl(SizeCategoryRepo sizeCategoryRepo) {
		super();
		this.sizeCategoryRepo = sizeCategoryRepo;
	}
	
	@Override
	public List<Category_Size> getAllCategorySize(){
		return sizeCategoryRepo.findAll();
	}

}
