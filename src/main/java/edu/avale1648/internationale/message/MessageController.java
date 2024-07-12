package edu.avale1648.internationale.message;

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
@RequestMapping("/messages")
public class MessageController {
	private final MessageRepository repository;
	
	public MessageController(MessageRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public List<Message> getAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Message getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(RuntimeException::new);
	}
	
	@PostMapping
	public ResponseEntity<Message> create(@RequestBody Message message) throws URISyntaxException {
		var saved = repository.save(message);
		
		return ResponseEntity.created(new URI(String.format("/messages/%s", saved.getId()))).body(saved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Message> update(@PathVariable Long id, @RequestBody Message message) {
		Message current = repository.findById(id).orElseThrow(RuntimeException::new);
		current = repository.save(new Message(message));
		
		return ResponseEntity.ok(current);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Message> deleteById(@PathVariable Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
}
