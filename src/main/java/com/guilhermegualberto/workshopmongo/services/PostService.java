package com.guilhermegualberto.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermegualberto.workshopmongo.domain.Post;
import com.guilhermegualberto.workshopmongo.repository.PostRepository;
import com.guilhermegualberto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found!") );
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitleContainingIgnoreCase(text);
		
	}

}