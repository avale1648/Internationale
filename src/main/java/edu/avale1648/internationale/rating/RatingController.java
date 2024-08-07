package edu.avale1648.internationale.rating;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	private final RatingRepository repository;

	public RatingController(RatingRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Rating> getAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Rating getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating) throws URISyntaxException {
		var saved = repository.save(rating);

		return ResponseEntity.created(new URI(String.format("/ratings/%s", saved.getId()))).body(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Rating> deleteById(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
