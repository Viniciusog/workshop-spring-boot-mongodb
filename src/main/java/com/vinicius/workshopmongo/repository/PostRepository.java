package com.vinicius.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.vinicius.workshopmongo.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'title'  : { $regex: ?0, $options: 'i' } } ")
	List<Post> searchTitle(String text);
	
	//Só essa declaração faz com que o spring date monte para agente a consulta - Aula 286
	//IgnoreCase o spring data já entende que é para ignorar letras maiusculas e minusculas
	List<Post> findByTitleContainingIgnoreCase(String text);
}
