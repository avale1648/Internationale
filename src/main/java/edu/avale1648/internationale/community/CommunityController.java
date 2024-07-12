package edu.avale1648.internationale.community;

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
@RequestMapping("/communities")
public class CommunityController {
	private final CommunityRepository repository;

	public CommunityController(CommunityRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Community> getAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Community getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity<Community> create(@RequestBody Community community) throws URISyntaxException {
		var saved = repository.save(community);

		return ResponseEntity.created(new URI(String.format("/communities/%s", saved.getId()))).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Community> update(@RequestBody Community community, @PathVariable Long id) {
		var current = repository.findById(id).orElseThrow(RuntimeException::new);
		current = repository.save(new Community(current));

		return ResponseEntity.ok(current);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Community> deleteById(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
