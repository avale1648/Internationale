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
	private String pfpUrl;
	private String bannerUrl;
	@OneToMany(mappedBy = "union", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> posts;
	@OneToMany(mappedBy = "union", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<User> users;

	public Union() {

	}

	public Union(String name, User founder, boolean isMature) {
		this.name = name;
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

	public String getPfpUrl() {
		return pfpUrl;
	}

	public void setPfpUrl(String pfpUrl) {
		this.pfpUrl = pfpUrl;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBanerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
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
