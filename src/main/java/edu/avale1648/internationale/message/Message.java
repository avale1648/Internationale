package edu.avale1648.internationale.message;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

import org.json.JSONObject;

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
@Table(name = "messages")
public class Message {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private User sender;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver_id", referencedColumnName = "id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private User receiver;
	private Timestamp date;
	private String text;
	private String file;

	public Message() {
		date = Timestamp.valueOf(LocalDateTime.now());
	}

	public Message(User sender, User receiver, String text, String file) {
		this();

		this.sender = sender;
		this.receiver = receiver;
		this.text = text;
		this.file = file;
	}

	public Message(Message other) {
		this(other.sender, other.receiver, other.text, other.file);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sender) + Objects.hash(receiver) + Objects.hash(date) + Objects.hash(text)
				+ Objects.hash(file);
	}

	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}

	public Long getId() {
		return id;
	}
	
	public User getSender() {
		return sender;
	}
	
	public User getReceiver() {
		return receiver;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String value) {
		text = value;
	}
	
	public String getFile() {
		return file;
	}
}
