package com.kumaran.MovieCruicerAuth.service;

import java.util.Map;

import com.kumaran.MovieCruicerAuth.model.User;

public interface SecurityTokenGenerator {

	Map<String, String> generateToken(User user);
}
