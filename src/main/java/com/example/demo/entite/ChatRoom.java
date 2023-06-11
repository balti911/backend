package com.example.demo.Entite;

import java.util.List;

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
	@Column(name="Room_Date")
    private String date;
	@Column(name="etat_chatrom")
	boolean etat;
	@Column(name="participates_user")
	private  List<User> participants;
	@Column(name=" shared_files")
	private List<File> sharedFile;
	@Column(name="description")
	private String decsription;
	//const empty 
	public ChatRoom()
	{}
	//const withe files 
	public ChatRoom(Long id, String nom, String date,List<User> participants,String description,boolean etat,List<File> sharedFile) {
		super();
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.participants=participants;
		this.decsription=description;
		this.etat=etat;
		this.sharedFile=sharedFile;
	}
	//getters and setters
	
	public Long getId() {
		return id;
	}
	
	public List<User> getParticipants() {
		return participants;
	}
	public void setParticipants(List<User> participants) {
		this.participants = participants;
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
	public String getDecsription() {
		return decsription;
	}
	public void setDecsription(String decsription) {
		this.decsription = decsription;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<File> getSharedFile() {
		return sharedFile;
	}
	public void setSharedFile(List<File> sharedFile) {
		this.sharedFile = sharedFile;
	}
	
	
}
