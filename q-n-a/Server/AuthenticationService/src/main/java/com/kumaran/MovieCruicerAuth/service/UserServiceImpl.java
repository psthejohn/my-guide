package com.kumaran.MovieCruicerAuth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumaran.MovieCruicerAuth.exceptions.UserAlreadyExistsException;
import com.kumaran.MovieCruicerAuth.exceptions.UserNotFoundException;
import com.kumaran.MovieCruicerAuth.model.User;
import com.kumaran.MovieCruicerAuth.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	
	private final UserRepository userRepo;

	@Autowired
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		
		User ul = userRepo.findByUserId(user.getUserId());
		if(ul != null) {
			throw new UserAlreadyExistsException("User with this Id already exists");
		}
		userRepo.save(user);
		
		return true;
	}

	@Override
	public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
		
		User user = userRepo.findByUserIdAndPassword(userId, password);
		
		if(user == null) {
			throw new UserNotFoundException("UserId and Password mismatch");
		}
		return user;
	}

	@Override
	public User findByUserId(String userId) throws UserNotFoundException {
		
		User user = userRepo.findByUserId(userId);
		
		return user;
	
	}
	

	
}
