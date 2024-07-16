package edu.avale1648.internationale.rating;

import java.util.Objects;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.avale1648.internationale.post.Post;
import edu.avale1648.internationale.user.User;
import edu.avale1648.internationale.util.rating.IllegalRatingValueException;
import edu.avale1648.internationale.util.rating.RatingValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ratings")
public class Rating {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Post post;
	private String value;
	
	public Rating() {}
	
	public Rating(User user, Post post, String value) {
		this.user = user;
		this.post = post;
		if(RatingValue.isValid(value)) {
			this.value = value;
		} else {
			throw new IllegalRatingValueException(String.format("Illegal rating value: %s", value));
		}
	}
	
	public Rating(Rating other) {
		this(other.user, other.post, other.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user) + Objects.hash(post) + Objects.hash(value);
	}
	
	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}
	
	public Long getId() {
		return this.id;
	}
	
	public User getUser() {
		return user;
	}
	
	public Post getPost() {
		return post;
	}
	
	public String getValue() {
		return value;
	}
}
