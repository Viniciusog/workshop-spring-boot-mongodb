package com.vinicius.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.workshopmongo.domain.User;
import com.vinicius.workshopmongo.dto.UserDTO;
import com.vinicius.workshopmongo.repository.UserRepository;
import com.vinicius.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	// Injeção de depêndencia automática do spring
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		User user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;

	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}

	public void delete(String id) {
		findById(id); // Fazer uma procura pelo id para ver se existe, se não tiver, vai retornar uma
						// exceção
		repo.delete(id);
	}

	public User update(User obj) {
		User newObj = repo.findOne(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);

	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());

	}
}
