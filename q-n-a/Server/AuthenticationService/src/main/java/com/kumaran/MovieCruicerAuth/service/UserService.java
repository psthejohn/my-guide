package com.kumaran.MovieCruicerAuth.service;

import com.kumaran.MovieCruicerAuth.exceptions.UserAlreadyExistsException;
import com.kumaran.MovieCruicerAuth.exceptions.UserNotFoundException;
import com.kumaran.MovieCruicerAuth.model.User;

public interface UserService {

	boolean saveUser(User user) throws UserAlreadyExistsException;
	
	public User findByUserIdAndPassword(String userId, String password) 
			throws UserNotFoundException;
	
	public User findByUserId(String userId) throws UserNotFoundException;
	
}
