package com.vinicius.workshopmongo.services;

import java.util.Date;
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
		return repo.searchTitle(text); 
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		//Para pegar os comentários entre datas, precisamos conferir todo o ultimo dia, pois por padrão a hora até um dia é até o instante 
		//apartir da meia noite deste dia
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
