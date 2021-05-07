package com.david.myapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.myapi.domain.User;
import com.david.myapi.repositories.UserRepository;
import com.david.myapi.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found Id: " + id + ", type: " + User.class.getName()));

	}

}
