package com.vinicius.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.vinicius.workshopmongo.domain.Post;
import com.vinicius.workshopmongo.domain.User;
import com.vinicius.workshopmongo.repository.PostRepository;
import com.vinicius.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		//Id recebe null pois o banco de dados vai gerar este id
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "vou viajar para São Paulo, abraço!", maria);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "bom dia", "Acordei Feliz hoje", maria);
		
		userRepository.save(Arrays.asList(maria, alex, bob));
		postRepository.save(Arrays.asList(post1, post2));
		
	}

}
