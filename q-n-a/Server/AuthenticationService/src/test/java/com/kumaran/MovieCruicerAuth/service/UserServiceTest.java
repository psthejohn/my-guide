package com.kumaran.MovieCruicerAuth.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.kumaran.MovieCruicerAuth.exceptions.UserAlreadyExistsException;
import com.kumaran.MovieCruicerAuth.exceptions.UserNotFoundException;
import com.kumaran.MovieCruicerAuth.model.User;
import com.kumaran.MovieCruicerAuth.repositories.UserRepository;

public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	private User user;

	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	Optional<User> options;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		user = new User("sonu3706","Chandan","Mishra","123456", new Date());
		options = Optional.of(user);
	}
	
	@Test
	public void testSaveUserSuccess() throws UserAlreadyExistsException {
		
		when(userRepository.save(user)).thenReturn(user);
		boolean flag = userServiceImpl.saveUser(user);
		assertEquals("Cannot Register  User", true, flag);
		verify(userRepository,times(1)).save(user);
	}
	
	@Test(expected = UserAlreadyExistsException.class)
	public void testSaveUserFailure() throws UserAlreadyExistsException{
		when(userRepository.findByUserId(user.getUserId())).thenReturn(user);
		when(userRepository.save(user)).thenReturn(user);
		boolean flag = userServiceImpl.saveUser(user);
	}
	
	@Test
	public void testValidateSuccess() throws UserNotFoundException {
		when(userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword()))
		.thenReturn(user);
		User userResult = userServiceImpl.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		assertNotNull(userResult);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void testValidateFailure() throws UserNotFoundException{
		
		when(userRepository.findByUserIdAndPassword("sonu","123456")).thenReturn(null);
		userServiceImpl.findByUserIdAndPassword("sonu", user.getPassword());
	}
}
