package com.example.demo.Entite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="administrator")
public class Administrator {
//Attribut
	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
@Column(name="nom_Admin")
private String nom;
@Column(name ="prenom_Admin")
private String  prenom;
@Column(name ="email_Admin")
private String email;
@Column(name="nom_util")
private String nom_util;
@Column(name="password")
private String password;
//constructor using file 
public Administrator(Long id, String nom, String prenom, String email ,String nom_util,String password ) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.nom_util=nom_util;
	this.password=password;
}
//getters and setters

public Long getId() {
	return id;
}
public String getNom_util() {
	return nom_util;
}

public void setNom_util(String nom_util) {
	this.nom_util = nom_util;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
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

}
