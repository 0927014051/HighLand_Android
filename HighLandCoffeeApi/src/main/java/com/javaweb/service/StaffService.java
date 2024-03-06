package com.javaweb.service;

import com.javaweb.entity.Staff;

public interface StaffService {
	
	Staff findStaffByUserId(Long user_id);
	
	Staff createStaff(Staff staff);

}
