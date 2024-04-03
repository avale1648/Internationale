package edu.avale1648.internationale.sql.models;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String url;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private Post post;

	public File() {
		this.url = "default";
	}

	public File(String url) {
		this.url = url;
	}

	public UUID getId() {
		return id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
