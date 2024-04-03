package edu.avale1648.internationale.sql.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Union {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String name;
	private String description;
	private User founder;
	private boolean isMature;
	private LocalDateTime cakeDate;
	private File profilePicture;
	private File banner;
	@OneToMany(mappedBy = "union", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> posts;
	@OneToMany(mappedBy = "union", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users;

	public Union() {

	}

	public Union(String name, String description, User founder, boolean isMature) {
		this.name = name;
		this.description = description;
		this.founder = founder;
		this.isMature = isMature;

		this.cakeDate = LocalDateTime.now();
		this.posts = new ArrayList<Post>();
		this.users = new ArrayList<User>();
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getFounder() {
		return founder;
	}

	public boolean getIsMature() {
		return isMature;
	}

	public LocalDateTime getCakeDate() {
		return cakeDate;
	}

	public File getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(File profilePicture) {
		this.profilePicture = profilePicture;
	}

	public File getBanner() {
		return banner;
	}

	public void setBanner(File banner) {
		this.banner = banner;
	}

	public void addPost(Post post) {
		post.setUnion(this);
		posts.add(post);
	}

	public void removePost(Post post) {
		posts.remove(post);
	}

	public void addUser(User user) {
		users.add(user);
	}

	public void removeUser(User user) {
		users.remove(user);
	}
}
