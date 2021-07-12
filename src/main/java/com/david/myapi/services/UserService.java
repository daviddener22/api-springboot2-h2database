package com.david.myapi.services;

import java.util.List;
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
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User update(Long id, User user) {
		User newObj = findById(id);
		newObj.setName(user.getName());
		newObj.setLogin(user.getLogin());
		newObj.setPassword(user.getPassword());
		return userRepository.save(newObj);
	}

	public User create(User user) {
		user.setId(null);
		return userRepository.save(user);
	}

	public void delete(Long id) {
		findById(id);
		userRepository.deleteById(id);
	}

}
