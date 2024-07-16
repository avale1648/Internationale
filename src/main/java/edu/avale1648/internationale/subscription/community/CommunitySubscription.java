package edu.avale1648.internationale.subscription.community;

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
@Table(name = "community_subscriptions")
public class CommunitySubscription {
	@Id
	@GeneratedValue
	Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "community_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Community community;
	
	public CommunitySubscription() {}

	public CommunitySubscription(User user, Community community) {
		this.user = user;
		this.community = community;
	}

	public CommunitySubscription(CommunitySubscription other) {
		this(other.user, other.community);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user) + Objects.hash(community);
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
	
	public Community getCommunity() {
		return community;
	}
}
