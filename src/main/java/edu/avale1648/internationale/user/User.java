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

		if (!Role.isValid(role)) {
			this.role = role;
		} else {
			throw new IllegalRoleException(String.format("Illegal role: %s", role));
		}

		this.description = description;
		this.pfp = pfp;
		this.banner = banner;
	}

	public User(User other) {
		this(other.name, other.email, other.password, other.birthdate, other.role, other.description, other.pfp, other.banner);
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
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String value) {
		email = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String value) {
		password = value;
	}
	
	public Timestamp getBirthdate() {
		return birthdate;
	}
	
	public Long getRating() {
		return rating;
	}
	
	public void setRating(Long value) {
		rating = value;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String value) {
		if(!Role.isValid(value)) {
			throw new IllegalRoleException(String.format("Illegal role: %s", value));
		}
		role = value;
	}
	
	public Timestamp getCakedate() {
		return cakedate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String value) {
		description = value;
	}
	
	public String getPfp() {
		return pfp;
	}
	
	public void setPfp(String value) {
		pfp = value;
	}
	
	public String getBanner() {
		return banner;
	}
	
	public void setBanner(String value) {
		banner = value;
	}
}