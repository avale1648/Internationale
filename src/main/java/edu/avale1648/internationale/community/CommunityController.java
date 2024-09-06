package edu.avale1648.internationale.community;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("http://localhost:3000")
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
	public ResponseEntity<Community> update( @PathVariable Long id, @RequestBody Community community) {
		Community current = repository.findById(id).orElseThrow(RuntimeException::new);
		
		current.setName(community.getName());
		current.setDescription(community.getDescription());
		current.setPfp(community.getPfp());
		current.setBanner(community.getBanner());
		current.setRating(community.getRating());
		
		current = repository.save(current);

		return ResponseEntity.ok(current);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Community> deleteById(@PathVariable Long id) {
		repository.deleteById(id);

		return ResponseEntity.ok().build();
	}
}
