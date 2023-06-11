package com.example.demo.Entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id ;
	@Column(name ="nom_user")
	private String nom;
	@Column(name ="prenom_user")
	private String prenom;
	@Column(name ="email_user")
	private String email;
    @Column(name="mot_pass")
	private String password ;
    @Column(name="nom_util")
    private String nomUtil;
    @Column(name="etat_user")
    boolean etat;
    //const 
	public User(Long id, String nom, String prenom, String email,String nomUtil, String password ,boolean etat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.nomUtil=nomUtil;
		this.password=password;
		this.etat=etat;
	}
	//G&S
	public Long getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNomUtil() {
		return nomUtil;
	}
	public void setNomUtil(String nomUtil) {
		this.nomUtil = nomUtil;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
	}
