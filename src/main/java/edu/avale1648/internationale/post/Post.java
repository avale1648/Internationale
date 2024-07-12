package edu.avale1648.internationale.post;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.avale1648.internationale.community.Community;
import edu.avale1648.internationale.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "community_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Community community;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_post_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Post parentPost;
	private String title;
	private String text;
	private Timestamp postDate;
	private Long rating;
	private String file;
	
	public Post() {
		this.rating = 0L;
		this.postDate = Timestamp.valueOf(LocalDateTime.now());
	}
	
	public Post(User user, Community community, Post parentPost, String title, String text, String file) {
		this();
		this.user = user;
		this.community = community;
		this.parentPost = parentPost;
		this.title = title;
		this.text = text;
		this.file = file;
	}
	
	public Post(Post other) {
		this(other.user, other.community, other.parentPost, other.title, other.text, other.file);
	}
	
	@Override
	public boolean equals(Object obj) {
		Post other = (Post) obj;

		return this.user == other.user && this.community == other.community && this.parentPost == other.parentPost
				&& this.rating == other.rating && this.postDate == other.postDate
				&& this.title == other.title && this.text == other.text && this.file == other.file;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user) + Objects.hash(community) + Objects.hash(parentPost) + Objects.hash(rating)
				+ Objects.hash(postDate) + Objects.hash(title) + Objects.hash(text) + Objects.hash(file);
	}
	
	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}
	
	public Long getId() {
		return id;
	}
}