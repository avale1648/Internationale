package edu.avale1648.internationale.subscription.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.avale1648.internationale.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_subscriptions")
public class UserSubscription {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subscriber_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	User subscriber;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	User author;
	
	public UserSubscription() {}
	
	public UserSubscription(User subscriber, User author) {
		this.subscriber = subscriber;
		this.author = author;
	}
	
	public UserSubscription(UserSubscription other) {
		this(other.subscriber, other.author);
	}
	
	public Long getId() {
		return this.id;
	}
}
