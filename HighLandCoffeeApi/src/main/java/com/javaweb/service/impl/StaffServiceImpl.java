package com.javaweb.service.impl;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Staff;
import com.javaweb.reponsitory.StaffRepo;
import com.javaweb.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{
	private StaffRepo staffRepo;

	public StaffServiceImpl(StaffRepo staffRepo) {
		super();
		this.staffRepo = staffRepo;
	}
	
	@Override
	public Staff findStaffByUserId(Long user_id) {
		return staffRepo.findStaffByUserId(user_id);
	}
	
	@Override
	public Staff createStaff(Staff staff) {
		return staffRepo.save(staff);
	}
}
