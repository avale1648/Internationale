package edu.avale1648.internationale.sql.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	// Data
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@Column(unique = true)
	private String name;
	private String description;
	private String email;
	private String password;
	/* birthdate */
	private LocalDateTime birthdate;
	/* registration dateTime */
	private LocalDateTime cakeDate;
	private File profilePicture;
	private File banner;
	// Posts
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> posts;
	// Unions, where user is member
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Union> unions;

	public User() {

	}

	public User(String name, String email, String password, LocalDateTime birthdate) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;

		this.description = "";
		this.cakeDate = LocalDateTime.now();
		posts = new ArrayList<Post>();
		unions = new ArrayList<Union>();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getBirthdate() {
		return birthdate;
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
		post.setUser(this);
		posts.add(post);
	}

	public void removePost(Post post) {
		posts.remove(post);
	}

	public void joinUnion(Union union) {
		unions.add(union);
	}

	public void leaveUnion(Union union) {
		unions.remove(union);
	}
}
