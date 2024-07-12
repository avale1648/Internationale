package edu.avale1648.internationale.user;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import org.json.JSONObject;

import edu.avale1648.internationale.util.role.IllegalRoleException;
import edu.avale1648.internationale.util.role.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true)
	private String name;
	private String email;
	private String password;
	private Timestamp birthdate;
	private Long rating;
	private String role;
	private Timestamp cakedate;
	private String description;
	private String pfp;
	private String banner;

	public User() {
		this.rating = 0L;
		this.role = Role.USER;
		this.cakedate = Timestamp.valueOf(LocalDateTime.now());
	}

	public User(String name, String email, String password, Timestamp birthdate, String role, String description,
			String pfp, String banner) {
		this();

		this.name = name;
		this.email = email;
		this.password = password;
		this.birthdate = birthdate;

		if (Role.isValid(role)) {
			this.role = role;
		} else {
			throw new IllegalRoleException(String.format("Illegal role: %s", role));
		}

		this.description = description;
		this.pfp = pfp;
		this.banner = banner;
	}

	public User(User other) {
		this.name = other.name;
		this.email = other.email;
		this.password = other.password;
		this.birthdate = other.birthdate;
		this.rating = other.rating;
		this.role = other.role;
		this.cakedate = other.cakedate;
		this.description = other.description;
		this.pfp = other.pfp;
		this.banner = other.banner;
	}

	// Long id, String name, String email, String password, Timestamp birthdate,
	// Long rating, String role, Timestamp birthdate, String description,
	// String pfp, String banner
	@Override
	public boolean equals(Object obj) {
		User u = (User) obj;

		return this.name == u.name && this.email == u.email && this.password == u.password
				&& this.birthdate == u.birthdate && this.rating == u.rating && this.role == u.role
				&& this.cakedate == u.cakedate && this.description == u.description && this.pfp == u.pfp
				&& this.banner == u.banner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id) + Objects.hash(name) + Objects.hash(email) + Objects.hash(password)
				+ Objects.hash(birthdate) + Objects.hash(rating) + Objects.hash(role) + Objects.hash(cakedate)
				+ Objects.hash(description) + Objects.hash(pfp) + Objects.hash(banner);
	}

	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}

	public Long getId() {
		return this.id;
	}
}