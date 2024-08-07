package edu.avale1648.internationale.user;

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
@RequestMapping("/users")
public class UserController {
	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<User> getAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) throws URISyntaxException {
		User savedUser = repository.save(user);

		return ResponseEntity.created(new URI(String.format("/users/%s", savedUser.getId()))).body(savedUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		User current = repository.findById(id).orElseThrow(RuntimeException::new);
		
		current.setName(user.getName());
		current.setEmail(user.getEmail());
		current.setPassword(user.getPassword());
		current.setRating(user.getRating());
		current.setRole(user.getRole());
		current.setDescription(user.getDescription());
		current.setPfp(user.getPfp());
		current.setBanner(user.getBanner());

		return ResponseEntity.ok(current);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteById(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
