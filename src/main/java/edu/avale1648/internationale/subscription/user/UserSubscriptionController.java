package edu.avale1648.internationale.subscription.user;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user_subscriptions")
@CrossOrigin("http://localhost:3000")
public class UserSubscriptionController {
	private final UserSubscriptionRepository repository;

	public UserSubscriptionController(UserSubscriptionRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<UserSubscription> getAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public UserSubscription getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity<UserSubscription> create(@RequestBody UserSubscription subscribtion) throws URISyntaxException {
		var saved = repository.save(subscribtion);

		return ResponseEntity.created(new URI(String.format("/user_subscriptions/%s", saved.getId()))).body(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UserSubscription> deleteById(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.ok().build();
	}
}