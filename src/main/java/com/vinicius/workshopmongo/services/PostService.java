package com.vinicius.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.workshopmongo.domain.Post;
import com.vinicius.workshopmongo.repository.PostRepository;
import com.vinicius.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	// Injeção de depêndencia automática do spring
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Post user = repo.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;

	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text); 
	}
}
