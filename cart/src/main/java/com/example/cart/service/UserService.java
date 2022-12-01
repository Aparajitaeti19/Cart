package com.example.cart.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.cart.entity.User;
import com.example.cart.exceptions.UserNotExistException;
import com.example.cart.repository.UserRepository;

@Service
public class UserService {
	 private UserRepository userRepository;
	 
	 public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	 
	 public User getUserById(Integer userId) throws UserNotExistException {
	        Optional<User> optionalUser = userRepository.findById(userId);
	        if (!optionalUser.isPresent())
	            throw new UserNotExistException("User id is invalid " + userId);
	        return optionalUser.get();
	    }
}
