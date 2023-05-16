package com.example.demo.Entite;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="hatRoomm")
public class ChatRoom {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@Column(name="nom_room")
	private String nom;
	@Column(name="Date_room")
    private String date;
	//const empty 
	public ChatRoom()
	{}
	//const withe files 
	public ChatRoom(Long id, String nom, String date) {
		super();
		this.id = id;
		this.nom = nom;
		this.date = date;
	}
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
