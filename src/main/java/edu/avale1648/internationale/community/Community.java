package edu.avale1648.internationale.community;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.avale1648.internationale.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "communities")
public class Community {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "founder_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private User founder;
	@Column(unique = true)
	private String name;
	private boolean mature;
	private Long rating;
	private Timestamp cakedate;
	private String description;
	private String pfp;
	private String banner;

	public Community() {
		this.mature = false;
		this.rating = 0L;
		this.cakedate = Timestamp.valueOf(LocalDateTime.now());
	}

	public Community(User founder, String name, String description, String pfp, String banner) {
		this();

		this.founder = founder;
		this.name = name;
		this.description = description;
		this.pfp = pfp;
		this.banner = banner;
	}

	public Community(User founder, String name, String description, String pfp, String banner, boolean mature) {
		this(founder, name, description, pfp, banner);

		this.mature = mature;
	}

	public Community(Community other) {
		this(other.founder, other.name, other.description, other.pfp, other.banner, other.mature);
	}

	@Override
	public boolean equals(Object obj) {
		Community other = (Community) obj;

		return this.founder == other.founder && this.name == other.name && this.mature == other.mature
				&& this.rating == other.rating && this.cakedate == other.cakedate
				&& this.description == other.description && this.pfp == other.pfp && this.banner == other.banner;
	}

	@Override
	public int hashCode() {
		return Objects.hash(founder) + Objects.hash(name) + Objects.hash(mature) + Objects.hash(rating)
				+ Objects.hash(cakedate) + Objects.hash(description) + Objects.hash(pfp) + Objects.hash(banner);
	}
	
	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}
	
	public Long getId() {
		return id;
	}
}
