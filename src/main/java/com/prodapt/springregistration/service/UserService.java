package com.prodapt.springregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prodapt.springregistration.entities.User;
import com.prodapt.springregistration.exceptions.InvalidCredentialsException;
import com.prodapt.springregistration.repositories.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository repo;

	public User save(User user) {
		return repo.save(user);
	}

	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}

	public User get(Long id) {
		return repo.findById(id).get();
	}

	public User loginUser(User user) throws InvalidCredentialsException {
		User usr = repo.findByUserName(user.getUserName());
		if (usr != null) {
			if (usr.getPassword().equals(user.getPassword())) {
				return usr;
			} else {
				throw new InvalidCredentialsException();
			}
		} else {
			throw new InvalidCredentialsException();
		}
	}

	public User updateUser(User user) {
		if (repo.existsById(user.getUserId())) {
			repo.save(user);
		}
		return user;
	}

	public void delete(long userId) {
		repo.deleteById(userId);

	}

	public List<User> search(String keyword) {
		return repo.search(keyword);
	}

	public User editUser(User user) {
		if (repo.existsById(user.getUserId())) {
			repo.save(user);
		}
		return user;
	}

	public void deleteUserById(Long userId) {
		repo.deleteById(userId);

	}

}
