package edu.avale1648.internationale.moderator;

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
@RequestMapping("/moderators")
public class ModeratorController {
	private final ModeratorRepository repository;

	public ModeratorController(ModeratorRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public List<Moderator> getAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Moderator getById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(RuntimeException::new);
	}

	@PostMapping
	public ResponseEntity<Moderator> create(@RequestBody Moderator moderator) throws URISyntaxException {
		var saved = repository.save(moderator);

		return ResponseEntity.created(new URI(String.format("/moderators/%s", saved.getId()))).body(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Moderator> update(@PathVariable Long id, @RequestBody Moderator moderator) {
		Moderator current = repository.findById(id).orElseThrow(RuntimeException::new);
		current = repository.save(new Moderator(moderator));

		return ResponseEntity.ok(current);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Moderator> deleteById(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.ok().build();
	}
}