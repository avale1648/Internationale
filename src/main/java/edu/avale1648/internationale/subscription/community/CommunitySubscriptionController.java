package edu.avale1648.internationale.subscription.community;

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
@RequestMapping("/community_subscriptions")
@CrossOrigin("http://localhost:3000")
public class CommunitySubscriptionController {
	private final CommunitySubscriptionRepository repository;

	public CommunitySubscriptionController(CommunitySubscriptionRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<CommunitySubscription> getAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public CommunitySubscription getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity<CommunitySubscription> create(@RequestBody CommunitySubscription subscribtion) throws URISyntaxException {
		var saved = repository.save(subscribtion);

		return ResponseEntity.created(new URI(String.format("/community_subscriptions/%s", saved.getId()))).body(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CommunitySubscription> deleteById(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
