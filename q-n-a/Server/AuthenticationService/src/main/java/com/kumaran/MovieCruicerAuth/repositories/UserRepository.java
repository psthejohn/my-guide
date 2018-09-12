package com.kumaran.MovieCruicerAuth.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kumaran.MovieCruicerAuth.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	/*@Query("Select u from User u where userId = (?1) and password= (?2)")
	User validate(String userId, String password);
*/
	User findByUserIdAndPassword(String userId, String password);
	
	User findByUserId(String userId);
	
	//User findByFirstNameAndLastName(String firstName, String lastName);
}
