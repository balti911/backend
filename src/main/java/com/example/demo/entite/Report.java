package com.example.demo.Entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "reports")
public class Report {
	@Id 
    @GeneratedValue (strategy = GenerationType .IDENTITY)
    private Long id;

    @Column (name="description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id")
    private User reporter;

    @ManyToOne(fetch = FetchType .LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;
    //constructor

	public Report(Long id, String description, User reporter, ChatRoom chatRoom) {
		super();
		this.id = id;
		this.description = description;
		this.reporter = reporter;
		this.chatRoom = chatRoom;
	}
    //getters & setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getReporter() {
		return reporter;
	}

	public void setReporter(User reporter) {
		this.reporter = reporter;
	}

	public ChatRoom getChatRoom() {
		return chatRoom;
	}

	public void setChatRoom(ChatRoom chatRoom) {
		this.chatRoom = chatRoom;
	}
	
 
}
