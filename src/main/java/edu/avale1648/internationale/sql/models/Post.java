package edu.avale1648.internationale.sql.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
	// Post Information: id, date and time, author and union
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private LocalDateTime postDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "union_id")
	private Union union;
	// post content: title, text, file(s) and rating
	private String text;
	private int rating;
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<String> fileUrls;
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> comments;

	public Post() {

	}

	public Post(User user, Union union, String text) {
		this.postDate = LocalDateTime.now();
		this.user = user;
		user.addPost(this);
		if (union != null) {
			this.union = union;
			union.addPost(this);
		}

		this.text = text;
		this.rating = 0;
		this.fileUrls = new ArrayList<String>();
		this.comments = new ArrayList<Post>();
	}

	// Information
	public UUID getId() {
		return this.id;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Union getUnion() {
		return this.union;
	}

	public void setUnion(Union union) {
		this.union = union;
	}

	// Content
	public String getText() {
		return this.text;
	}

	public void SetText(String text) {
		this.text = text;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int value) throws IllegalArgumentException {
		if (value != 1 || value != -1) {
			throw new IllegalArgumentException("Value of increment should be one or negative one");
		}
		this.rating += value;
	}

	public void addFileUrl(String fileUrl) {
		fileUrls.add(fileUrl);
	}

	public void removeFile(String fileUrl) {
		fileUrls.remove(fileUrl);
	}
}
