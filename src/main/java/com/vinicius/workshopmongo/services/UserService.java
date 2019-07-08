package com.vinicius.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.workshopmongo.domain.User;
import com.vinicius.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	//Injeção de depêndencia automática do spring
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
