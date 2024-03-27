package com.javaweb.service;

import com.javaweb.entity.Size;
import com.javaweb.request.AddCategorySizeRequest;

public interface SizeService {

	public Size createSize(AddCategorySizeRequest size,Long staff_id);
}
