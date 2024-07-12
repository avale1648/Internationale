package edu.avale1648.internationale.post;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
	private final PostRepository repository;
	
	public PostController(PostRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Post> getAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}") 
	public Post getById(@PathVariable Long id){
		return repository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	@PostMapping
	public ResponseEntity<Post> create(@RequestBody Post post) throws URISyntaxException {
		var saved = repository.save(post);
		
		return ResponseEntity.created(new URI(String.format("/posts/%s", saved.getId()))).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody Post post) {
		Post current = repository.findById(id).orElseThrow(RuntimeException::new);
		current = repository.save(new Post(post));
		
		return ResponseEntity.ok(current);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
}
