package com.javaweb.service;

import java.util.List;

import com.javaweb.entity.User;
import com.javaweb.exception.UserException;
import com.javaweb.request.ProfileUserRequest;
import com.javaweb.response.ProfileUserAndCustomerResponse;

public interface UserService {

	public List<User> getAllUsers() throws UserException;

	public User findUserById(Long userId) throws UserException;

	public ProfileUserRequest findUserProfileByJwt(String jwt) throws UserException;

	public ProfileUserAndCustomerResponse updateUserAndCustomerProfileByJwt(String jwt, ProfileUserRequest update) throws UserException;
}
