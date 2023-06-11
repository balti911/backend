package com.example.demo.Entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "statistics")
public class Statistics {
	@Id 
    @GeneratedValue (strategy = GenerationType .IDENTITY)
    private Long id;

    @Column (name="registeredUsers")
    private static int registeredUsers;

    @Column(name ="activechatRooms" )
    private static int activeChatRooms;
//constructor 

	public Statistics(Long id, int registeredUsers, int activeChatRooms) {
		super();
		this.id = id;
		this.registeredUsers = registeredUsers;
		this.activeChatRooms = activeChatRooms;
	}
    //Getters &Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRegisteredUsers() {
		return registeredUsers;
	}

	public void setRegisteredUsers(int registeredUsers) {
		this.registeredUsers = registeredUsers;
	}

	public int getActiveChatRooms() {
		return activeChatRooms;
	}

	public void setActiveChatRooms(int activeChatRooms) {
		this.activeChatRooms = activeChatRooms;
	}
	
}
